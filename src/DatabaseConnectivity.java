import java.awt.Color;
import java.awt.Font;
import java.security.*;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JLabel;
import org.apache.commons.validator.routines.UrlValidator;


public class DatabaseConnectivity {
    
    static String website="";
    static String email="";
    static String password="";
    private static SecretKeySpec secretKey;
    private static byte[] key;
    
    public static boolean validateEmail(String email_data){
        Pattern ptr = Pattern.compile("(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)");
        
        if(ptr.matcher(email).matches())
            return true;
        else
            return false;
    }
    
    public static boolean validateWebsite(){
        UrlValidator defaultValidator = new UrlValidator();
        return defaultValidator.isValid(website);
    }
    
    public static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encrypt(String strToEncrypt, String secret) {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String secret) {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static String[] encryptpwd(String pwd){
    	Random random = new Random();
        final String secretkey = String.valueOf(random.nextInt());
               
        String originalString = pwd;
        String encryptedString = DatabaseConnectivity.encrypt(originalString, secretkey);
        String encryptedkey = DatabaseConnectivity.encrypt(secretkey, encryptedString);
        
        String arr[] = {encryptedString, encryptedkey};
        return arr;
    }

    public static String decryptpwd(String encryptedString, String encryptedkey){
    	String decryptedkey = DatabaseConnectivity.decrypt(encryptedkey, encryptedString);
    	String decryptedString = DatabaseConnectivity.decrypt(encryptedString, decryptedkey);

    	return decryptedString;
    }    
    
    public static void addData() throws Exception{
        Statement statementObj = DatabaseUtil.getConnection().createStatement();
        website = AddData_Panel.website_text.getText();
        email = AddData_Panel.email_text.getText();
        password = String.valueOf(AddData_Panel.password_text.getPassword());
        
        if(!validateWebsite())
        {
            PWD.status.setText("Enter valid website");
            PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
            PWD.status.setOpaque(true);
            PWD.status.setHorizontalAlignment(JLabel.CENTER);
            PWD.status.setForeground(Color.red);
        }
        else
        {
            if(!validateEmail(email))
            {
                PWD.status.setText("Enter valid email");
                PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
                PWD.status.setOpaque(true);
                PWD.status.setHorizontalAlignment(JLabel.CENTER);
                PWD.status.setForeground(Color.red);
            }
            else
            {
                String password_data[] = encryptpwd(password);
                String encrypted_pwd = password_data[0];
                String pwdkey = password_data[1];

                ResultSet rs = statementObj.executeQuery("select * from data where email='"+email+"' and website='"+website+"'");
                if(!rs.next())
                {
                    String query = String.format("insert into data (website, email, password, pwdkey) values ('%s', '%s', '%s', '%s')", website, email, encrypted_pwd, pwdkey);
                    int isSuccess = statementObj.executeUpdate(query);
                    
                    if(isSuccess>0)
                    {
                        PWD.status.setText("Data added successfully");
                        PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
                        PWD.status.setOpaque(true);
                        PWD.status.setHorizontalAlignment(JLabel.CENTER);
                        PWD.status.setForeground(new Color(75, 181, 67));
                    } 
                    else
                    {
                        PWD.status.setText("An error has occured");
                        PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
                        PWD.status.setOpaque(true);
                        PWD.status.setHorizontalAlignment(JLabel.CENTER);
                        PWD.status.setForeground(Color.red);
                    }
                }
                else
                {
                    PWD.status.setText("Email already exists");
                    PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
                    PWD.status.setOpaque(true);
                    PWD.status.setHorizontalAlignment(JLabel.CENTER);
                    PWD.status.setForeground(Color.red);
                }
            }
        }
    }
    
    public static String viewData() throws Exception{
        Statement statementObj = DatabaseUtil.getConnection().createStatement();
        ResultSet rs = statementObj.executeQuery("select DISTINCT website from data");
        String decrypted_pwd = "";
        
        while(rs.next())
        {
            ViewData_Panel.website_cb.addItem(rs.getString("website"));
        }
        
        String website_data = (String)ViewData_Panel.website_cb.getSelectedItem();
        rs = statementObj.executeQuery("select email from data where website='"+website_data+"'");
        
        while(rs.next())
        {
            ViewData_Panel.email_cb.addItem(rs.getString("email"));
        }
        
        String email_data = (String)ViewData_Panel.email_cb.getSelectedItem();
        
        rs = statementObj.executeQuery("select * from data where email='"+email_data+"' and website='"+website_data+"'");
        while(rs.next())
        {
            String en_password = rs.getString("password");
            String pwd_key = rs.getString("pwdkey");
            decrypted_pwd = decryptpwd(en_password, pwd_key);
        }
        return decrypted_pwd;
    }
    
    public static void displayUpdateData() throws Exception{
        Statement statementObj = DatabaseUtil.getConnection().createStatement();
        ResultSet rs = statementObj.executeQuery("select DISTINCT website from data");
        
        while(rs.next())
        {
            UpdateData_Panel.website_cb.addItem(rs.getString("website"));
        }
        
        String website_data = (String)UpdateData_Panel.website_cb.getSelectedItem();
        rs = statementObj.executeQuery("select email from data where website='"+website_data+"'");
        
        while(rs.next())
        {
            UpdateData_Panel.email_cb.addItem(rs.getString("email"));
        }
    }
    
    public static void updateData() throws Exception{
        
        Statement statementObj = DatabaseUtil.getConnection().createStatement();
        
        website = (String)UpdateData_Panel.website_cb.getSelectedItem();
        String email_data = (String)UpdateData_Panel.email_cb.getSelectedItem();
        
        if(UpdateData_Panel.check_email.isSelected()){
            email = UpdateData_Panel.email_text.getText();
        }
        else{
            email = email_data;
        }
        
        if(UpdateData_Panel.check_password.isSelected())
            password = String.valueOf(UpdateData_Panel.password_text.getPassword());
        
        if(!validateEmail(email))
        {
            PWD.status.setText("Enter valid email");
            PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
            PWD.status.setOpaque(true);
            PWD.status.setHorizontalAlignment(JLabel.CENTER);
            PWD.status.setForeground(Color.red);
        }
        else
        {
            statementObj.executeUpdate("update data set email='"+email+"' where website='"+website+"' and email='"+email_data+"'");
            
            String password_data[] = encryptpwd(password);
            String encrypted_pwd = password_data[0];
            String pwdkey = password_data[1];

            
            int isSuccess = statementObj.executeUpdate("update data set password='"+encrypted_pwd+"', pwdkey='"+pwdkey+"' where website='"+website+"' and email='"+email+"'");

            if(isSuccess>0)
            {
                PWD.status.setText("Data updated successfully");
                PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
                PWD.status.setOpaque(true);
                PWD.status.setHorizontalAlignment(JLabel.CENTER);
                PWD.status.setForeground(new Color(75, 181, 67));
            } 
            else
            {
                PWD.status.setText("An error has occured");
                PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
                PWD.status.setOpaque(true);
                PWD.status.setHorizontalAlignment(JLabel.CENTER);
                PWD.status.setForeground(Color.red);
            }
        }
    }
    
    public static void displayDeleteData() throws Exception{
        Statement statementObj = DatabaseUtil.getConnection().createStatement();
        ResultSet rs = statementObj.executeQuery("select DISTINCT website from data");
        
        while(rs.next())
        {
            DeleteData_Panel.website_cb.addItem(rs.getString("website"));
        }
        
        String website_data = (String)DeleteData_Panel.website_cb.getSelectedItem();
        rs = statementObj.executeQuery("select email from data where website='"+website_data+"'");
        
        while(rs.next())
        {
            DeleteData_Panel.email_cb.addItem(rs.getString("email"));
        }
    }

    public static void deleteData() throws Exception{
        Statement statementObj = DatabaseUtil.getConnection().createStatement();
        website = (String)DeleteData_Panel.website_cb.getSelectedItem();
        email = (String)DeleteData_Panel.email_cb.getSelectedItem();
        
        int isSuccess = statementObj.executeUpdate("delete from data where website ='"+website+"' and email = '"+email+"' ");
        
        if(isSuccess>0)
        {
            PWD.status.setText("Data deleted successfully");
            PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
            PWD.status.setOpaque(true);
            PWD.status.setHorizontalAlignment(JLabel.CENTER);
            PWD.status.setForeground(new Color(75, 181, 67));
        } 
        else
        {
            PWD.status.setText("An error has occured");
            PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
            PWD.status.setOpaque(true);
            PWD.status.setHorizontalAlignment(JLabel.CENTER);
            PWD.status.setForeground(Color.red);
        }
    }
}
