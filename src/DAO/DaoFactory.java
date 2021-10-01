package DAO;



import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DaoFactory {

    private String url ;
    private String username ;
    private String password ;
    private Connection connection ;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("driver ok");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreure 1");
        }

        DaoFactory instance=new DaoFactory("jdbc:mysql://localhost:3306/rse","root","1234");

        return instance ;

    }

    public Connection getConnection() throws SQLException{
        try {
            connection= DriverManager.getConnection(url, username, password) ;
            //System.out.println("connexion reussi");
        } catch (SQLException e) {
            System.out.println("Ereure 2");
        }
        return connection;
    }



    public PublicationDao getPublicationDao(){
         return new PublicationDaoImpl(this) ;
    }

    public MembreDao getMembreDao(){
        return new MembreDaoImpl(this);
    }

    public CommentaireDao getCommentaireDao(){
        return new CommentaireDaoImpl(this);
    }

    public NotificationDao getNotificationDao(){
        return new NotificationDaoImpl(this);
    }

    public static String extractFileName (Part part) {
        String contentDisp=  part.getHeader("content-disposition");
        String[] items =contentDisp.split(";");
        for(String s:items){
            if(s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=")+2,s.length()-1);
            }
        }
        return "";
    }

    public static  String  saveFiles(Collection<Part> parts){
        String savePath = "C:\\Users\\Abderahim\\intelj\\RSE\\web\\static\\stokage";
        double v=  Math.random()*10000000;


        String path=savePath+ File.separator+"file"+v;
        File file=new File(path);
        while (file.exists()){
            v= Math.random()*10000000;
            path=savePath+File.separator+"file"+v;
            file=new File(path);
        }
        file.mkdir();
        for (Part part :parts){
            String fileName =DaoFactory.extractFileName(part);
            if (!fileName.equals("")) {
                try {
                    part.write(path+File.separator + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return path ;
    }

    public static void zipFile(String filePath) {
        List<String> fileList=new ArrayList<>();
        String OUTPUT_ZIP_FILE = filePath+".zip";
         String SOURCE_FOLDER = filePath;

        generateFileList(new File(SOURCE_FOLDER),fileList,SOURCE_FOLDER);

        byte[] buffer = new byte[1024];
        try{
            FileOutputStream fos = new FileOutputStream(OUTPUT_ZIP_FILE);
            ZipOutputStream zos = new ZipOutputStream(fos);
            //System.out.println("Output to Zip : " + OUTPUT_ZIP_FILE);
            for(String file : fileList){
                //System.out.println("File Added : " + file);
                ZipEntry ze= new ZipEntry(file);
                zos.putNextEntry(ze);
                FileInputStream in =
                        new FileInputStream(SOURCE_FOLDER + File.separator + file);
                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                in.close();
            }
            zos.closeEntry();
            //remember close it
            zos.close();
            //System.out.println("Done");
            deleteDirectory(new File(SOURCE_FOLDER));
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
    private static void generateFileList(File node , List<String> fileList , String SOURCE_FOLDER){
        //add file only
        if(node.isFile()){
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString(),SOURCE_FOLDER));
        }
        if(node.isDirectory()){
            String[] subNote = node.list();
            for(String filename : subNote){
                generateFileList(new File(node, filename),fileList,SOURCE_FOLDER);
            }
        }
    }
    private static String generateZipEntry(String file,String SOURCE_FOLDER){
        return file.substring(SOURCE_FOLDER.length()+1, file.length());
    }
    private static void deleteDirectory(File file) throws IOException {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectory(entry);
                }
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete " + file);
        }
    }

}
