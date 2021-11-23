import java.security.MessageDigest;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
public class HashCrack{
    static String read(String location) throws IOException{
        File f=new File(location);
        String text="";
        try (FileReader fileStream = new FileReader(f);
             BufferedReader bufferedReader = new BufferedReader(fileStream)) {
            String line = null;
            while ((line = bufferedReader.readLine())!= null) {
                text=line;
            }
        }
        return text;
    }
     static String sha1(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
  
            BigInteger no = new BigInteger(1, messageDigest);
  
            String hashtext = no.toString(16);
  
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
  
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    static String sha256(String data){
		try{
			final MessageDigest digest = MessageDigest.getInstance("SHA-256");
			final byte[] hash = digest.digest(data.getBytes("UTF-8"));
			final StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < hash.length; i++) {
				final String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) 
				  hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch(Exception ex){
		   throw new RuntimeException(ex);
		}
	}
    static String md5(String data){
        try{
			final MessageDigest digest = MessageDigest.getInstance("MD5");
			final byte[] hash = digest.digest(data.getBytes("UTF-8"));
			final StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < hash.length; i++) {
				final String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) 
				  hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch(Exception ex){
		   throw new RuntimeException(ex);
		}
    }
    static int getfilelinenum(File a) throws FileNotFoundException, IOException{
        int count=0;
        try (FileReader fileStream = new FileReader(a);
               BufferedReader bufferedReader = new BufferedReader(fileStream)) {
            String line = null;
            while ((line = bufferedReader.readLine())!= null) {
              count++;
            }
          }
          return count;
    }
    static double percentage(int x, int y){
        return (x*100)/y;
    }
    static String md2(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String sha224(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-224");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String sha384(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-384");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String sha512(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException, FileNotFoundException{
        System.out.println("██╗░░██╗░█████╗░░██████╗██╗░░██╗░█████╗░██████╗░░█████╗░░█████╗░██╗░░██╗");
        System.out.println("██║░░██║██╔══██╗██╔════╝██║░░██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░██╔╝");
        System.out.println("███████║███████║╚█████╗░███████║██║░░╚═╝██████╔╝███████║██║░░╚═╝█████═╝░");
        System.out.println("██╔══██║██╔══██║░╚═══██╗██╔══██║██║░░██╗██╔══██╗██╔══██║██║░░██╗██╔═██╗░");
        System.out.println("██║░░██║██║░░██║██████╔╝██║░░██║╚█████╔╝██║░░██║██║░░██║╚█████╔╝██║░╚██╗");
        System.out.println("╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝");
        try{
        String mhash=args[0];
        int counter=0;
        File f=new File(args[1]);
        String type= args[2];
      
        int numlines=getfilelinenum(f);
        System.out.println(f.getAbsolutePath()+" has "+numlines+" entries.");
        System.out.println("Cracking...");
        if(type.equals("SHA256")){
        try (FileReader fileStream = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileStream)) {
       String line = null;
       while ((line = bufferedReader.readLine())!= null) {
           if(sha256(line).equals(mhash)){
               System.out.println(line + " is the hash.");
               System.exit(0);
           }
           else{
               counter=counter+1;
               System.out.println("Tried " + line + " , failed." + counter +" out of " + numlines + "(" + (float)counter*100/numlines + "%)");
           }
       }
   }
   System.out.println("Hash not found in " + f.getAbsolutePath());
}
        else if(type.equals("MD5")){
            try (FileReader fileStream = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileStream)) {
           String line = null;
           while ((line = bufferedReader.readLine())!= null) {
               if(md5(line).equals(mhash)){
                   System.out.println(line + " is the hash.");
                   System.exit(0);
               }
               else{
                   counter=counter+1;
                   System.out.println("Tried " + line + " , failed." + counter +" out of " + numlines + "(" + (float)counter*100/numlines + "%)");
               }
           }
       }
       System.out.println("Hash not found in " + f.getAbsolutePath());
    }
    else if(type.equals("SHA1")){
        try (FileReader fileStream = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileStream)) {
       String line = null;
       while ((line = bufferedReader.readLine())!= null) {
           if(sha1(line).equals(mhash)){
               System.out.println(line + " is the hash.");
               System.exit(0);
           }
           else{
               counter=counter+1;
               System.out.println("Tried " + line + " , failed." + counter +" out of " + numlines + "(" + (float)counter*100/numlines + "%)");
           }
       }
    }
    System.out.println("Hash not found in " + f.getAbsolutePath());
}
    else if(type.equals("MD2")){
        try (FileReader fileStream = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileStream)) {
       String line = null;
       while ((line = bufferedReader.readLine())!= null) {
           if(md2(line).equals(mhash)){
               System.out.println(line + " is the hash.");
               System.exit(0);
           }
           else{
               counter=counter+1;
               System.out.println("Tried " + line + " , failed." + counter +" out of " + numlines + "(" + (float)counter*100/numlines + "%)");
           }
       }
    }
    System.out.println("Hash not found in " + f.getAbsolutePath());
}
    else if(type.equals("SHA224")){
        try (FileReader fileStream = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileStream)) {
       String line = null;
       while ((line = bufferedReader.readLine())!= null) {
           if(sha224(line).equals(mhash)){
               System.out.println(line + " is the hash.");
               System.exit(0);
           }
           else{
               counter=counter+1;
               System.out.println("Tried " + line + " , failed." + counter +" out of " + numlines + "(" + (float)counter*100/numlines + "%)");
           }
       }
    }
    System.out.println("Hash not found in " + f.getAbsolutePath());
}
    else if(type.equals("SHA384")){
        try (FileReader fileStream = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileStream)) {
       String line = null;
       while ((line = bufferedReader.readLine())!= null) {
           if(sha384(line).equals(mhash)){
               System.out.println(line + " is the hash.");
               System.exit(0);
           }
           else{
               counter=counter+1;
               System.out.println("Tried " + line + " , failed." + counter +" out of " + numlines + "(" + (float)counter*100/numlines + "%)");
           }
       }
    }
    System.out.println("Hash not found in " + f.getAbsolutePath());
}
    else if(type.equals("SHA512")){
        try (FileReader fileStream = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileStream)) {
       String line = null;
       while ((line = bufferedReader.readLine())!= null) {
           if(sha512(line).equals(mhash)){
               System.out.println(line + " is the hash.");
               System.exit(0);
           }
           else{
               counter=counter+1;
               System.out.println("Tried " + line + " , failed." + counter +" out of " + numlines + "(" + (float)counter*100/numlines + "%)");
           }
       }
    }
    System.out.println("Hash not found in " + f.getAbsolutePath());
}
    else{
        System.out.println("Invalid type. List of types:-");
        System.out.println("1. SHA256");
        System.out.println("2. MD5");
        System.out.println("3. SHA1");
        System.out.println("4. MD2");
        System.out.println("5. SHA224");
        System.out.println("6. SHA384");
        System.out.println("7. SHA512");
    }
}
  catch(ArrayIndexOutOfBoundsException e){
    System.out.println("Invalid number of arguments. List of arguments:-");
    System.out.println("1. Hash");
    System.out.println("2. wordlist of plain words.");
    System.out.println("3. Type of hash");
    System.out.println("Usage: java SHACrack hash pathtowordlist typeofhash");
  }
    }
}