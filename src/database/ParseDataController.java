package database;

import models.Book;
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

            books.add(new Book(jsonObject.get("title").toString(),
                    jsonObject.get("author").toString(),
                    Integer.valueOf(jsonObject.get("launchYear").toString()),
                    jsonObject.get("category").toString(),
                    Integer.valueOf(jsonObject.get("pages").toString())));
        }

        return books;
    }
}
