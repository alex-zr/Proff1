

import java.util.ArrayList;
import java.util.List;

public class PeopleList {

    private static final PeopleList singeltonList = new PeopleList();
    private List<People> peopleList = new ArrayList<>();

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    private PeopleList() {
    }

    public synchronized void addPeople(People people){
        this.getPeopleList().add(people);
    }

    public static PeopleList getInstance(){
        return singeltonList;
    }

}
