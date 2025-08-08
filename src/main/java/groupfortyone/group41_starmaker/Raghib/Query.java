package groupfortyone.group41_starmaker.Raghib;

import java.util.ArrayList;

public class Query {
    private String username;
    private String query;


    public static ArrayList<String> queryList=new ArrayList<>();


    public Query(String username, String query) {
        this.username = username;
        this.query = query;
    }

    public Query() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Query{" +
                "username='" + username + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}
