//THINGS TO FIX
// 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class collegemanager {

  static final char ur = '\u2557';
  static final char ul = '\u2554';
  static final char top = '\u2550';
  static final char side = '\u2551';
  static final char sideTL = '\u2560';
  static final char sideRL = '\u2563';
  static final char bl = '\u255A';
  static final char br = '\u255D';
  static final char one = '\u2776';
  static final char two = '\u2777';
  static final char thr = '\u2778';
  static final char fou = '\u2779';
  static final char fiv = '\u277A';
  static final char six = '\u277B';
  static final char sev = '\u277C';
  static final char eig = '\u277D';
  static final char nin = '\u277E';
  static final char ten = '\u277F';
  static final char ele = '\u277F';

  // ----------------------------------------------------------------
  // ---------------- G L O B A L V A R I A B L E S ------------
  // ----------------------------------------------------------------
  String colName;
  String range;
  int priv;
  int accept;
  int gpa;
  int rank;
  ArrayList<college> colleges = new ArrayList<college>();
  Scanner input = new Scanner(System.in);
  boolean flag = false;

  public static void main(String[] args) {
    collegemanager es = new collegemanager(); // invoke constructor
  }

  /**
   *
   * @param text        give me a text expression
   * @param totalLength total length of String to be filled
   * @return a String of spaces to "pad" the region where len = total.len-text.len
   */
  public String padding(String text, int totalLength) {
    int difference = totalLength - text.length();
    if (difference > 0) {

      for (int i = 0; i < difference; i++) {
        text += " ";
      }
    }
    return text;
  }

  public collegemanager() {
    menu();
  }

  public void menu() {

    while (true) {
      Date now = new Date();
      System.out.print("\t\t" + ul);
      for (int i = 0; i < 41; i++) {
        System.out.print(top);
      }
      // _________________________________________");
      System.out.println(ur);
      System.out.println("\t\t" + side + "        Colleges I want to Apply To      " + side);
      System.out.print("\t\t" + sideTL);

      for (int i = 0; i < 41; i++) {
        System.out.print(top);
      }
      // _________________________________________
      System.out.println(sideRL);
      System.out.println("\t\t" + side + "        " + one + " = Add                          " + side);
      System.out.println("\t\t" + side + "        " + two + " = Display                      " + side);
      System.out.println("\t\t" + side + "        " + thr + " = Sort                         " + side);
      System.out.println("\t\t" + side + "        " + fou + " = Edit                         " + side);
      System.out.println("\t\t" + side + "        " + fiv + " = Delete                       " + side);
      System.out.println("\t\t" + side + "        " + six + " = Read Text                    " + side);
      System.out.println("\t\t" + side + "        " + sev + " = Saves                        " + side);
      System.out.println("\t\t" + side + "        " + eig + " = Archives                     " + side);
      System.out.println("\t\t" + side + "        " + nin + " = Write File                   " + side);
      System.out.println("\t\t" + side + "        " + ten + " = Exit                         " + side);
      System.out.println("\t\t" + side + "        " + ele + " = Encrypt File                 " + side);
      System.out.println("\t\t" + side + "        " + ele + " = Decrypt File                 " + side);

      System.out.println("\t\t" + side + "  Your Selection?                        " + side);
      System.out.print("\t\t" + bl);
      for (int i = 0; i < 41; i++) {
        System.out.print(top);
      }
      // +"_________________________________________
      System.out.println(br);

      int choice = input.nextInt();
      switch (choice) {
        case 1:
          add();
          break;
        case 2:
          display();
          break;
        case 3:
          sort();
          break;
        case 4:
          edit();
          break;
        case 5:
          delete();
          break;
        case 6:
          readText();
          break;
        case 7:
          listAllFiles();
          break;
        case 8:
          archives();
          break;
        case 9:
          writeFile();
          break;
        case 10:
          exit();
          break;
        case 11:
          encryptFile();
          break;
        case 12:
          decryptFile();
          break;
      }
    }
  }

  public void exit() {
    System.out.println("WARNING... Did you save your changes to your file? (1 for yes, 2 for no)");
    int option = input.nextInt();
    if (option == 1) {
      System.exit(0);
    } else {
      menu();
    }

  }

  public void add() {
    System.out.println("Which College would you like to add? 0 for N/A");
    input.skip("\n");
    colName = input.nextLine();
    System.out.println("What is the SAT Range? 0 for N/A");
    range = input.next();
    System.out.println("Is it a Private School? 1 for yes, 2 for no... 0 for N/A");// true, false
    priv = input.nextInt();
    System.out.println("Acceptance Rate? 0 for N/A");
    accept = input.nextInt();
    System.out.println("What is the required GPA? 0 for N/A");
    gpa = input.nextInt();
    System.out.println("What is the School Ranking? 0 for N/A");
    rank = input.nextInt();
    colleges.add(new college(colName, range, priv, accept, gpa, rank));
  }

  public void display() {
    System.out.println(
        "\tCollege Name-----------SAT Range-----------Private School?-----------Acceptance Rate-----------GPA-------------Ranking");
    for (int i = 0; i < colleges.size(); i++) {
      System.out.print((i + 1) + "\t");

      if (colleges.get(i).getName() == null || colleges.get(i).getName().equals("0")) {
        System.out.print(padding("N/A", 23));
      } else {
        System.out.print(padding(colleges.get(i).getName(), 23));
      }

      if (colleges.get(i).getSatRange() == null || colleges.get(i).getSatRange().equals("0")) {
        System.out.print(padding("N/A", 25));
      } else {
        System.out.print(padding(colleges.get(i).getSatRange(), 25));
      }
      if (colleges.get(i).getPrivateSchool() == null || colleges.get(i).getPrivateSchool().equals("0")) {
        System.out.print(padding("N/A", 27));
      } else {
        System.out.print(padding(colleges.get(i).getPrivateSchool(), 27));
      }
      if (colleges.get(i).getAcceptanceRate() == null || colleges.get(i).getAcceptanceRate().equals("0")) {
        System.out.print(padding("N/A", 20));
      } else {
        System.out.print(padding(colleges.get(i).getAcceptanceRate(), 20));
      }
      if (colleges.get(i).getGPA() == null || colleges.get(i).getGPA().equals("0")) {
        System.out.print(padding("N/A", 20));
      } else {
        System.out.print(padding(colleges.get(i).getGPA(), 20));
      }
      if (colleges.get(i).getRank() == null || colleges.get(i).getRank().equals("0")) {
        System.out.print(padding("N/A", 20));
      } else {
        System.out.print(padding(colleges.get(i).getRank(), 20));
      }
      System.out.println("");
    }
  }

  public void sort() {
    System.out.println(
        "What would you like to sort by? \n1 for College Names\n2for SAT Range\n3 for Private Schools\n4 for Acceptance Rates\n5 for GPA for Admission\n6 for Ranking");
    int sortInput = input.nextInt();

    if (sortInput == 1) {
      Collections.sort(colleges, new NameComparator());
    }
    if (sortInput == 2) {
      Collections.sort(colleges, new SATComparator());
    }
    if (sortInput == 3) {
      Collections.sort(colleges, new PrivateSchoolComparator());
    }
    if (sortInput == 4) {
      Collections.sort(colleges, new AcceptanceComparator());
    }
    if (sortInput == 5) {
      Collections.sort(colleges, new GPAComparator());
    }
    if (sortInput == 6) {
      Collections.sort(colleges, new RankComparator());
    }

    System.out.println("Successfully Updated");

  }

  public void edit() {
    display();
    System.out.println("Which colleges would you like to edit");
    int choice = input.nextInt();
    choice -= 1;
    System.out.println(
        "What would you like to edit about this colleges?\n1 for College Names\n2for SAT Range\n3 for Private Schools\n4 for Acceptance Rates\n5 for GPA for Admission\n6 for Ranking");
    int editInput = input.nextInt();
    if (editInput == 1) {
      System.out.println("What would you like to change the name to? 0 for N/A");
      String name = input.next();
      colleges.get(choice).changeName(name);
      System.out.println("Successfully Updated");
    }
    if (editInput == 2) {
      System.out.println("What would you like to change the SAT Range to? 0 for N/A");
      String range = input.next();
      colleges.get(choice).changeSATRange(range);
      System.out.println("Successfully Updated");
    }
    if (editInput == 3) {
      System.out.println("1 for Private School, 2 for no, 0 for N/A");
      int priv = input.nextInt();
      colleges.get(choice).changePrivSchool(priv);
      System.out.println("Successfully Updated");
    }
    if (editInput == 4) {
      System.out.println("What would you like to change the Acceptance Rate to? 0 for N/A");
      int accept = input.nextInt();
      colleges.get(choice).changeAcceptanceRate(accept);
      System.out.println("Successfully Updated");
    }
    if (editInput == 5) {
      System.out.println("What would you like to change the GPA to? 0 for N/A");
      int GPA = input.nextInt();
      colleges.get(choice).changeGPA(GPA);
      System.out.println("Successfully Updated");

    }
    if (editInput == 6) {
      System.out.println("What would you like to change the Ranking to? 0 for N/A");
      int rank = input.nextInt();
      colleges.get(choice).changeRank(rank);
      System.out.println("Successfully Updated");

    }

  }

  public void delete() {
    System.out.println("Do you wish to delete a file or a college?(1 for file.. 2 for college)");
    int choice = input.nextInt();
    if (choice == 1) {
      deleteFile();
    } else {

      display();
      System.out.println("Which colleges would you like to remove?");
      int remove = input.nextInt();
      remove -= 1;
      colleges.remove(remove);
    }
  }

  public void deleteFile() {
    File[] files = new File("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/").listFiles();
    int count = 1;
    for (File file : files) {
      if (file.isDirectory()) {
        continue;
      } else {
        System.out.println(count + " - File: " + file.getName());
        count++;
      }
    }
    System.out.println("Which file would you like to delete?");
    input.skip("\n");
    String del = input.nextLine();
    try {
      for (File file : files) {
        if (del.equals(file.getName())) {
          if (file.renameTo(new File(
              "/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/archives/" + file.getName())))
            ;
          System.out.println("File moved to archives!");
        }
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  public void readText() {
    try {
      System.out.println("What file would you like to open?");
      String write = input.next();
      BufferedReader input = new BufferedReader(
          new FileReader("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/" + write + ".txt"));
      String line;
      // Attemp to read from the file
      line = input.readLine();
      while (line != null) {// goes to the end of file
        StringTokenizer st = new StringTokenizer(line, "|");// | is the delimiter
        // Now break up the line
        colName = st.nextToken();
        range = st.nextToken();
        priv = Integer.parseInt(st.nextToken());
        accept = Integer.parseInt(st.nextToken());
        gpa = Integer.parseInt(st.nextToken());
        rank = Integer.parseInt(st.nextToken());
        line = input.readLine();
        colleges.add(new College(colName, range, priv, accept, gpa, rank));
      }
      System.out.println("List Redered!");
      input.close();
    } catch (Exception e) {
      System.out.println("problemo");
      System.out.println(e.toString());
    }

  }

  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  public void listAllFiles() {
    File[] files = new File("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/").listFiles();
    for (File file : files) {
      if (file.isDirectory()) {
        continue;
      } else {
        System.out.println("File: " + file.getName());
      }
    }
  }

  public void listTxtOnly() {

    File[] files = new File("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/").listFiles();
    for (File file : files) {
      if ((!file.toString().contains("decrypted") || !file.toString().contains("encrypted"))
          && file.toString().contains(".txt")) {
        System.out.println("File: " + file.getName());
        flag = true;
      }
    }
    if (!flag) {
      System.out.println("there are no text files!");
    }
    flag = false;
  }

  public void listDecOnly() {
    int count = 0;
    File[] files = new File("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/").listFiles();
    for (File file : files) {
      if (file.toString().contains("decrypted")) {
        System.out.println("File: " + file.getName());
        flag = true;
      }
    }
    if (!flag) {
      System.out.println("there are no text files!");
    }
    flag = false;
  }

  public void listEncOnly() {
    File[] files = new File("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/").listFiles();
    for (File file : files) {
      if (file.toString().contains("encrypted")) {
        System.out.println("File: " + file.getName());
        flag = true;

      }
    }
    if (!flag) {
      System.out.println("there are no text files!");
    }
    flag = false;
  }

  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  // FILE LISTER
  public void archives() {
    File[] files = new File("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/archives/")
        .listFiles();
    for (File file : files) {
      System.out.println("File: " + file.getName());
    }
  }

  public void writeFile() {
    // College Name-----------SAT Range-----------Private
    // School?-----------Acceptance Rate----------GPA ----------Ranking
    try {
      System.out.println("Enter the name you would like to save the file as");
      String txtName = input.next();
      BufferedWriter writer = new BufferedWriter(
          new FileWriter("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/" + txtName + ".txt"));
      for (int i = 0; i < colleges.size(); i++) {
        writer.write(colleges.get(i).getName() + "|" + colleges.get(i).getSatRange() + "|"
            + colleges.get(i).getPrivAsNum() + "|" + colleges.get(i).getAcceptanceRate() + "|"
            + colleges.get(i).getGPA() + "|" + colleges.get(i).getRank() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }

  // ENCRYPTION AND DECRYPTION
  // ENCRYPTION AND DECRYPTION
  // ENCRYPTION AND DECRYPTION
  // ENCRYPTION AND DECRYPTION
  private static final String ALGORITHM = "Blowfish";
  private static String keyString = "ineedextracredit";

  public void encrypt(File inputFile, File outputFile) throws Exception {
    doCrypto(Cipher.ENCRYPT_MODE, inputFile, outputFile);
    System.out.println("File encrypted successfully!");
  }

  public void decrypt(File inputFile, File outputFile) throws Exception {
    doCrypto(Cipher.DECRYPT_MODE, inputFile, outputFile);
    System.out.println("File decrypted successfully!");
  }

  private void doCrypto(int cipherMode, File inputFile, File outputFile) throws Exception {

    Key secretKey = new SecretKeySpec(keyString.getBytes(), ALGORITHM);
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(cipherMode, secretKey);

    FileInputStream inputStream = new FileInputStream(inputFile);
    byte[] inputBytes = new byte[(int) inputFile.length()];
    inputStream.read(inputBytes);

    byte[] outputBytes = cipher.doFinal(inputBytes);

    FileOutputStream outputStream = new FileOutputStream(outputFile);
    outputStream.write(outputBytes);

    inputStream.close();
    outputStream.close();

  }

  public void encryptFile() {
    System.out.println("Enter key to access encryption");
    String keyStr = input.next();
    if (keyStr.equals(keyString)) {
      // load files that are only text files that are not encrypted nor decrypted
      listTxtOnly();
      System.out.println("Enter the file you would like to encrypt: ");
      String en = input.next();
      File inputFile = new File("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/" + en);
      en = en.replaceAll(".txt", "");
      File encryptedFile = new File(
          "/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/" + en + ".encrypted");
      try {
        encrypt(inputFile, encryptedFile);
        en = en.concat(".txt");
        if (en.equals(inputFile.getName())) {
          if (inputFile.renameTo(new File("/Users/chrisrosales/Documents/secretlocation/" + inputFile.getName())))
            ;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Key is incorrect!");
    }
  }

  public void decryptFile() {
    System.out.println("Enter key to access decryption");
    String keyStr = input.next();
    if (keyStr.equals(keyString)) {
      // load files that only are encrypted
      listEncOnly();
      System.out.println("Enter the file you would like to decrypt: ");
      String en = input.next();
      File inputFile = new File("/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/" + en);
      en = en.replaceAll(".encrypted", "");
      File decryptedFile = new File(
          "/Users/chrisrosales/Your team Dropbox/APCSNEW/Assignment11New/TextBin/" + en + ".txt");
      try {
        decrypt(inputFile, decryptedFile);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Key is incorrect!");
    }
  }
}
