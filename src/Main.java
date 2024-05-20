import domain.Bootcamp;
import domain.Course;
import domain.Dev;
import domain.Mentoring;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Course course1 = new Course();
        course1.setTitle("Java Course");
        course1.setDescription("Java description");
        course1.setWorkload(10);

        Mentoring mentoring = new Mentoring();
        mentoring.setTitle("Java Mentoring");
        mentoring.setDescription("Java Mentoring Description");
        mentoring.setDate(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Java Bootcamp");
        bootcamp.setDescription("Bootcamp Java Description");
        bootcamp.getContent().add(course1);
        bootcamp.getContent().add(mentoring);

        Dev devCindyHJ = new Dev();
        devCindyHJ.setName("Cindy");
        devCindyHJ.subscribeBootcamp(bootcamp);
        System.out.println("Subscribed Content: "+ devCindyHJ.getSubscribedContent());
        devCindyHJ.progress();
        System.out.println("==========");
        System.out.println("Subscribed Content: "+ devCindyHJ.getSubscribedContent());
        System.out.println("Completed Content: "+ devCindyHJ.getCompletedContent());
        System.out.println("XP:" + devCindyHJ.calcTotalXp());

    }

}