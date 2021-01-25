package numberPlate;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        System.out.println((new Main()).isEmailValide("fahad.yahya14@gmail.com"));
    }

    public void MakeEmailRed(boolean Exist,String Msg) {
        if (!EmailID.getStyleClass().contains("error"))
            EmailID.getStyleClass().add("error");

        Invalid.setVisible(!Exist);
        AlreadyExist.setVisible(Exist);
    }

    public void isEmailValide(String Email){
        String[] CompanyName = {"yahoo", "gmail", "hotmail"};
        String[] CompanyPath = {"org", "com"};

        if (Email.contains("@")) {
            String company = Email.substring(Email.lastIndexOf("@") + 1);
            if (company.length() != 0) {
                int iend = company.indexOf(".");
                if (iend != -1) {
                    String emailCompany = company.substring(0, iend);
                    String com_org = company.substring(company.lastIndexOf(".") + 1);
                    if (emailCompany.equals(CompanyName[0]) || emailCompany.equals(CompanyName[1]) || emailCompany.equals(CompanyName[2])) {
                        if (com_org.equals(CompanyPath[0]) || com_org.equals(CompanyPath[1])) {
                            String path_two = "C:\\Tawny\\Users\\";
                            path_two = path_two + Email;
                            File Dir2 = new File(path_two);
                            if (!Dir2.exists())
                                System.out.println("Hi");
//                                AlreadyExist.setVisible(false);
                            else {
                                MakeEmailRed(true,"Already Exist Dir");
//                                CreatedSuccessfully.setVisible(false);
                            }
                        }//"Invalid sytnx (.org,com)"
                        else MakeEmailRed(false,"Invalid sytnx (.org,com)");
                    }
                    else MakeEmailRed(false,"Invalid sytnx email type ("+company.toString()+")");
                }
                else MakeEmailRed(false,"Missing sytnx (.org,com)");
            } // company name is emtpy
            else MakeEmailRed(false,"Missing after @ sign 408 empty");
        } // na @ available ho na dot
        else  MakeEmailRed(false,"Missing @ sign");
    }
}
