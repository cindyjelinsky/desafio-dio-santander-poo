package domain;

import java.util.*;

public class Dev {
        private String name;
        private Set<Content> subscribedContent = new LinkedHashSet<>();
        private Set<Content> completedContent = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getSubscribedContent() {
        return subscribedContent;
    }

    public void setSubscribedContent(Set<Content> subscribedContent) {
        this.subscribedContent = subscribedContent;
    }

    public Set<Content> getCompletedContent() {
        return completedContent;
    }

    public void setCompletedContent(Set<Content> completedContent) {
        this.completedContent = completedContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev dev)) return false;

        if (!Objects.equals(name, dev.name)) return false;
        if (!Objects.equals(subscribedContent, dev.subscribedContent))
            return false;
        return Objects.equals(completedContent, dev.completedContent);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (subscribedContent != null ? subscribedContent.hashCode() : 0);
        result = 31 * result + (completedContent != null ? completedContent.hashCode() : 0);
        return result;
    }

    public void subscribeBootcamp(Bootcamp bootcamp){
        this.subscribedContent.addAll(bootcamp.getContent());
        bootcamp.getSubscribedDevs().add(this);
    }

    public void progress(){
        Optional<Content> content = this.subscribedContent.stream().findFirst();
        if(content.isPresent()){
            this.completedContent.add(content.get());
            this.subscribedContent.remove(content.get());
        }else {
            System.out.println("You don't have any subscriptions");

        }

    }

    public double calcTotalXp(){
        Iterator<Content> iterator = this.completedContent.iterator();
        double sum = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcXp();
            sum += next;
        }
        return sum;
    }

}
