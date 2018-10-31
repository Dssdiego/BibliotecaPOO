package database;

import models.Book;
import models.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ParseDataController {

    public static ArrayList<Book> getBooks() throws IOException {

        JSONObject bookJSON = Parse.getObject(Parse.bookTableRef);
        JSONArray jsonArray = (JSONArray) bookJSON.get("results");

        ArrayList<Book> books = new ArrayList<>();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;

            books.add(new Book(jsonObject.get("objectId").toString(),
                    jsonObject.get("title").toString(),
                    jsonObject.get("author").toString(),
                    Integer.valueOf(jsonObject.get("launchYear").toString()),
                    jsonObject.get("category").toString(),
                    Integer.valueOf(jsonObject.get("pages").toString())));
        }

        return books;
    }

    public static Boolean insertBook(String title, String author, String pages, String launchYear, String category) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("title", title);
        obj.put("author", author);
        obj.put("pages", Integer.parseInt(pages));
        obj.put("launchYear", Integer.parseInt(launchYear));
        obj.put("category", category);

        return Parse.postObject(Parse.bookTableRef, obj.toJSONString());
    }

    public static Boolean editBook(String objectId, String title, String author, String pages, String launchYear, String category) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("title", title);
        obj.put("author", author);
        obj.put("pages", Integer.parseInt(pages));
        obj.put("launchYear", Integer.parseInt(launchYear));
        obj.put("category", category);

        return Parse.editObject(Parse.bookTableRef, obj.toJSONString(), objectId);
    }

    public static ArrayList<Employee> getEmployees() throws IOException {

        JSONObject bookJSON = Parse.getObject(Parse.employeeTableRef);
        JSONArray jsonArray = (JSONArray) bookJSON.get("results");

        ArrayList<Employee> employees = new ArrayList<>();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;

            employees.add(new Employee(jsonObject.get("objectId").toString(),
                    jsonObject.get("name").toString(),
                    jsonObject.get("phone").toString()));
        }

        return employees;
    }

    public static Boolean insertEmployee(String name, String phone, String pages, String launchYear, String category) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("phone", phone);

        return Parse.postObject(Parse.employeeTableRef, obj.toJSONString());
    }
}
