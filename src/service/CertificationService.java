package service;

import entity.Certification;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CertificationService {

    public Connection connection;

    public CertificationService(){
        connection = ConnectDBUtil.openConnection();
    }

    public List<Certification> findAllCertification() throws Exception {
        String sql = "SELECT * FROM CHUNGNHAN";
        Statement statement;
        List<Certification> certificationList = new ArrayList<>();

        try {

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Certification certification = new Certification();
               certification.setIdEmployee(resultSet.getString(1));
               certification.setIdPlane(resultSet.getInt(2));
               certificationList.add(certification);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificationList;
    }

}
