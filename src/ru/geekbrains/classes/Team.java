package ru.geekbrains.classes;

import ru.geekbrains.classes.animals.Cat;
import ru.geekbrains.classes.animals.Dog;

public class Team {

    private String nameTeam;
    private Participant[] participants;

    public Team (String nameTeam) {
        this.nameTeam = nameTeam;


        participants = new Participant[] {
                  new Cat("Барсик", 10, 12, 0),
                  new Dog("Дружок", 20, 5, 15),
                  new Cat("Мурзик", 9, 14, 0),
                  new Robot("Вертер", 50, 50, 50)
        };
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void getInfoTeam () {
        System.out.println ("Члены команды " + nameTeam + ":");
        for (Participant participant : participants) {
            System.out.println(participant.getName());
        }
    }

    public void getInfoDistance () {
        System.out.println("Итоги:");
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }

}
