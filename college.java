/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chrisrosales
 */
public class college implements Comparable {
  // ----------------------------------------------------------------
  // ------ I N S T A N C E V A R I A B L E S / F I E L D S --------
  // ----------------------------------------------------------------

  public String collegeName, satRange, nicheGrade, val, rnk;
  public int acceptanceRate, netPrice, gradePointAverage, privateSchool, ranking;
  //////////////////////////////////////////////////////////////////
  /////////////// C O N S T R U C T O R S ///////////////
  //////////////////////////////////////////////////////////////////

  public college(String nam, String sat, int priv, int accept, int GPA, int rank) {
    collegeName = nam;
    satRange = sat;
    privateSchool = priv;
    acceptanceRate = accept;
    gradePointAverage = GPA;
    ranking = rank;
  }

  public college() {

  }

  public college(String nam) {
    collegeName = nam;
  }
  // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
  // AAAAAAAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAA
  // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

  public String getRank() {
    rnk = Integer.toString(ranking);
    return rnk;
  }

  public String getName() {
    return collegeName;
  }

  public String getSatRange() {
    return satRange;
  }

  public int getPrivAsNum() {
    return privateSchool;
  }

  public String getPrivateSchool() {
    val = Integer.toString(privateSchool);
    if (privateSchool == 1) {
      val = "Yes";
    }
    if (privateSchool == 2) {
      val = "No";
    }
    return val;
  }

  public String getAcceptanceRate() { // convert to string
    String accept = Integer.toString(acceptanceRate);
    return accept;
  }

  public int getNetPrice() {
    return netPrice;
  }

  public String getGPA() { // convert to string
    String gradePoint = Integer.toString(gradePointAverage);
    return gradePoint;
  }
  // MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
  // MMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMM
  // MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM

  public void changeName(String name) {
    collegeName = name;
  }

  public void changeSATRange(String range) {
    satRange = range;
  }

  public void changePrivSchool(int priv) {
    privateSchool = priv;
  }

  public void changeAcceptanceRate(int accept) {
    acceptanceRate = accept;
  }

  public void changeGPA(int grade) {
    gradePointAverage = grade;
  }

  public void changeRank(int rank) {
    ranking = rank;
  }

  @Override
  public int compareTo(Object o) {
    throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools
                                                                   // | Templates.
  }

}
