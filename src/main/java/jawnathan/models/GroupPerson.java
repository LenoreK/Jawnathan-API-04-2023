package jawnathan.models;

public class GroupPerson {
    private int PersonId;
    private Group group;

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
