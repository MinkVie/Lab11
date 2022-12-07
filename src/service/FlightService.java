package service;

import entity.Flight;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FlightService {

    private Connection connecttion;

    public FlightService() {
        connecttion = ConnectDBUtil.openConnection();
    }

    public List<Flight> findAllFlight() {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT * FROM CHUYENBAY";
        Statement statement;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Flight flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }

    public List<Flight> findDADFlight() {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE GaDen = 'DAD'";
        Statement statement;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }

    public List<Flight> findLenght8and10() {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE DoDai< 10000 AND DoDai > 8000";
        Statement statement;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }


    public List<Flight> findSGNandBMV() {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE GaDi = 'SGN' and GaDen = 'BMV'";
        Statement statement;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }


    public List<Flight> findSGN() {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE GaDi = 'SGN'";
        Statement statement;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }

    public List<Flight> flyByAirbusA320() {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY CB JOIN MAYBAY MB ON CB.DoDai < MB.TamBay\n" +
                "WHERE MB.Loai LIKE '%Airbus A320%'";
        Statement statement;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }

}
