package controller;

import entity.ClassRoom;
import entity.Student;
import service.ClassRoomService;
import service.StudentService;
import service.impl.ClassRoomServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet{
    private StudentService studentService;
    private ClassRoomService classRoomService;
    public StudentController(){
        studentService = new StudentServiceImpl();
        classRoomService = new ClassRoomServiceImpl();
    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                createView(request, response);
                break;
            case "edit":
                editView(request, response);
                break;
            default:
                viewStudent(request, response);
        }
    }

    private void editView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Student student = null;
        try {
            student = studentService.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<ClassRoom> classRoomList;
        try {
            classRoomList = classRoomService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("elementListMin", classRoomList);
        request.setAttribute("element",student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/editStudent.jsp");
        dispatcher.forward(request, response);
    }

    private void createView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ClassRoom> classRoomList;
        try {
            classRoomList = classRoomService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("elementListMin", classRoomList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/createStudent.jsp");
        dispatcher.forward(request, response);
    }

    private void viewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = null;
        try {
            studentList = studentService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("elementList",studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/student.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<Student> studentList = null;
        try {
            studentList = studentService.search(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("elementList",studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/student.jsp");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            studentService.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/student");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int cId = Integer.parseInt(request.getParameter("cId"));
        boolean isResult;
        try {
            isResult = studentService.edit(id,name, dateOfBirth, address, phoneNumber, email, cId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<ClassRoom> classRoomList;
        try {
            classRoomList = classRoomService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("elementListMin", classRoomList);
        request.setAttribute("success", isResult);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/editStudent.jsp");
        dispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int cId = Integer.parseInt(request.getParameter("cId"));
        boolean isResult;
        try {
            isResult = studentService.create(name, dateOfBirth, address, phoneNumber, email, cId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("success", isResult);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/createStudent.jsp");
        dispatcher.forward(request, response);
    }
}
