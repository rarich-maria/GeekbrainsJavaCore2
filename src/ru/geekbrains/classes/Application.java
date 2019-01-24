package ru.geekbrains.classes;

public class Application {

    public static void main(String[] args) {

        Team team = new Team("Сборная");
        Course course = new Course();

        team.getInfoTeam();

        course.goCourse(team);
        team.getInfoDistance();

    }
}
