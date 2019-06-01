package org.demo;

public class Worker {

    private String login;
    private String position;
    private int sinceYear;
    private String company;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSinceYear() {
        return sinceYear;
    }

    public void setSinceYear(int sinceYear) {
        this.sinceYear = sinceYear;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Worker{");
        sb.append("login='").append(login).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", sinceYear=").append(sinceYear);
        sb.append('}');
        return sb.toString();
    }
}
