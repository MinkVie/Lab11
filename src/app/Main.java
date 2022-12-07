package app;

import entity.Certification;
import entity.Employee;
import entity.Flight;
import entity.Plane;
import service.CertificationService;
import service.EmployeeService;
import service.FlightService;
import service.PlaneService;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        EmployeeService employeeService = new EmployeeService();
        FlightService flightService = new FlightService();
        CertificationService certificationService = new CertificationService();
        PlaneService planeService = new PlaneService();

        int select;
        Scanner sc = new Scanner(System.in);
        System.out.print("choose your funtion: ");

        do {
            System.out.println("____________________________");
            System.out.println("\t101.\tShow all Employee");
            System.out.println("\t102.\tShow all Flight");
            System.out.println("\t103.\tShow all Certification");
            System.out.println("\t104.\tShow all Plane");
            System.out.println("\t105.\tInsert Employee");
            System.out.println("\t106.\tExit");
            System.out.println("\t1.\tCho biết các chuyến bay đi Đà Lạt (DAD).");
            System.out.println("\t2.\tCho biết các loại máy bay có tầm bay lớn hơn 10,000km.");
            System.out.println("\t3.\tTìm các nhân viên có lương nhỏ hơn 10,000.");
            System.out.println("\t4.\tCho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.");
            System.out.println("\t5.\tCho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).");
            System.out.println("\t6.\tCó bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).");
            System.out.println("\t7.\tCó bao nhiêu loại máy báy Boeing.");
            System.out.println("\t8.\tCho biết tổng số lương phải trả cho các nhân viên.");
            System.out.println("\t9.\tCho biết mã số của các phi công lái máy báy Boeing.");
            System.out.println("\t10.\tCho biết các nhân viên có thể lái máy bay có mã số 747");
            System.out.println("\t11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.");
            System.out.println("\t12.\tCho biết các loại máy bay có thể thực hiện mã số của các phi công vừa lái được Boeing vừa lái được Airbus.");
            System.out.println("\t13. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.");
            System.out.println("\t14.\tCho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.");
            System.out.println("\t15.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("____________________________");

            select = sc.nextInt();
            switch (select) {
                case 101: {
                    List<Employee> employeeList = employeeService.findAllEmployee();
                    employeeList.stream().forEach(element -> System.out.println(element.getIdEmployee() + " " + element.getName() + " " + element.getSalary()));

                    break;
                }
                case 102: {
                    List<Flight> flightList = flightService.findAllFlight();
                    flightList.stream().forEach(element -> System.out.println(element.getIdFlight() +" " +element.getGoStation()
                            + " " +element.getArrivalStation() + " " +element.getLenght() + " "
                            + element.getDepartureTime() + " " + element.getArriveTime() +" " + element.getCost()));

                    break;
                }
                case 103: {
                    List<Certification> certificationList = certificationService.findAllCertification();
                    certificationList.stream().forEach(element -> System.out.println(element.getIdEmployee() + " " + element.getIdPlane()));

                    break;
                }
                case 104: {
                    List<Plane> planeList = planeService.findAllPlane();
                    planeList.stream().forEach(element -> System.out.println(element.getIdPlane() + " " + element.getType() + " " + element.getFlightRange()));

                    break;
                }
                case 105: {
                    Employee employee = new Employee();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter Employee ID: ");
                    employee.setIdEmployee(scanner.nextLine());
                    System.out.println("Enter Employee Name: ");
                    employee.setName(scanner.nextLine());
                    System.out.println("Enter Employee Salary: ");
                    employee.setSalary(scanner.nextInt());

                    employeeService.insertEmployee(employee.getIdEmployee(), employee.getName(), employee.getSalary());

                    break;
                }
                case 1: {
                    List<Flight> flightList = flightService.findDADFlight();
                    flightList.stream().forEach(element -> System.out.println(element.getIdFlight() +" " +element.getGoStation()
                            + " " +element.getArrivalStation() + " " +element.getLenght() + " "
                            + element.getDepartureTime() + " " + element.getArriveTime() +" " + element.getCost()));

                    break;
                }
                case 2: {
                    List<Plane> planeList = planeService.findRange();
                    planeList.stream().forEach(element -> System.out.println(element.getIdPlane()
                            + " " + element.getType() + " " + element.getFlightRange()));

                    break;
                }
                case 3: {
                    List<Employee> employeeList = employeeService.findSalaryEmployee10000();
                    employeeList.stream().forEach(element -> System.out.println(element.getIdEmployee()
                            + " " + element.getName() + " " + element.getSalary()));
                    break;
                }
                case 4: {
                    List<Flight> flightList = flightService.findLenght8and10();
                    flightList.stream().forEach(element -> System.out.println(element.getIdFlight() +" " +element.getGoStation()
                            + " " +element.getArrivalStation() + " " +element.getLenght() + " "
                            + element.getDepartureTime() + " " + element.getArriveTime() +" " + element.getCost()));

                    break;
                }
                case 5: {
                    List<Flight> flightList = flightService.findSGNandBMV();
                    flightList.stream().forEach(element -> System.out.println(element.getIdFlight() +" " +element.getGoStation()
                            + " " +element.getArrivalStation() + " " +element.getLenght() + " "
                            + element.getDepartureTime() + " " + element.getArriveTime() +" " + element.getCost()));

                    break;
                }
                case 6: {
                    List<Flight> flightList = flightService.findSGN();
                    System.out.println("There are " +flightList.size() +" flights departing from Saigon: ");
                    flightList.stream().forEach(element -> System.out.println(element.getIdFlight() +" " +element.getGoStation()
                            + " " +element.getArrivalStation() + " " +element.getLenght() + " "
                            + element.getDepartureTime() + " " + element.getArriveTime() +" " + element.getCost()));

                    break;
                }
                case 7: {
                    List<Plane> planeList = planeService.countBoeing();
                    System.out.println("There are "+planeList.size() + " types of Boeing aircraft: ");
                    planeList.stream().forEach(element -> System.out.println(element.getIdPlane()
                            + " " + element.getType() + " " + element.getFlightRange()));
                    break;
                }
                case 8: {
                   System.out.println("Sum salary of all employee is: "+employeeService.sumSalary());
                    break;

                }
                case 9: {
                    List<Employee> employeeList = employeeService.codePilotBoeing();
                    System.out.println(" boeing driver code is: ");
                    employeeList.stream().forEach(element -> System.out.println( element.getIdEmployee()));
                    break;
                }
                case 10: {
                    List<Employee> employeeList = employeeService.pilot747();
                    System.out.println(" 747 driver is: ");
                    employeeList.stream().forEach(element -> System.out.println(element.getIdEmployee()
                            + " " + element.getName() + " " + element.getSalary()));
                    break;
                }
                case 11: {
                    List<Plane> planeList = planeService.driverByNguyen();
                    System.out.println("codes of aircrafts that employees with the last name Nguyen can fly is:  ");
                    planeList.stream().forEach(element -> System.out.println(element.getIdPlane()));

                    break;
                }
                case 12: {
                    List<Employee> employeeList = employeeService.pilotBoeingAndAirbus();
                    System.out.println(" boeing and airbus driver code is: ");
                    employeeList.stream().forEach(element -> System.out.println( element.getIdEmployee()));
                    break;
                }
                case 13: {
                    List<Plane> planeList = planeService.planeCanVN280();
                    System.out.println("type of aircraft that can make flight VN280 is:  ");
                    planeList.stream().forEach(element -> System.out.println((element.getType())));

                    break;
                }
                case 14: {
                    List<Flight> flightList = flightService.flyByAirbusA320();
                    System.out.println("flights can be made by Airbus A320 aircraft is: ");
                    flightList.stream().forEach(element -> System.out.println(element.getIdFlight() +" " +element.getGoStation()
                            + " " +element.getArrivalStation() + " " +element.getLenght() + " "
                            + element.getDepartureTime() + " " + element.getArriveTime() +" " + element.getCost()));

                    break;
                }
                case 15: {
                    List<Employee> employeeList = employeeService.pilotBoeing();
                    System.out.println(" boeing and airbus driver name is: ");
                    employeeList.stream().forEach(element -> System.out.println( element.getName()));
                    break;
                }
                case 106: {
                    System.out.println("Exit");
                    System.exit(0);
                }
            }
        }
        while (select != 0);


    }
}