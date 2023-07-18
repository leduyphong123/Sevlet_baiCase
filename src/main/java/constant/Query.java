package constant;

public class Query {
    public static final String R_STUDENT = "SELECT * FROM STUDENT";
    public static final String R_CLASSROOM = "SELECT * FROM CLASSROOM";
    public static final String C_STUDENT = "INSERT INTO STUDENT (NAME,DATE_OF_BIRTH,ADDRESS,PHONE_NUMBER,EMAIL,C_ID) VALUES (?,?,?,?,?,?)";
    public static final String U_STUDENT = "UPDATE STUDENT SET NAME = ?,DATE_OF_BIRTH = ?,ADDRESS = ?,PHONE_NUMBER = ?,EMAIL = ?,C_ID=? WHERE ID = ?";
    public static final String D_STUDENT = "DELETE FROM STUDENT WHERE ID = ?";
    public static final String R_NAME_STUDENT = "SELECT *FROM STUDENT WHERE NAME LIKE ?";
}
