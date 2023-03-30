package ie.umbrella.bike.club.util;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    MemberRepository memberRepository;
    @Override
    public void run(String... args) throws Exception {
        memberRepository.save(new Member("Apples.Ack@gmail.com", "Apples", "Ack"));
        memberRepository.save(new Member("Butter.Beer@gmail.com", "Butter", "Beer"));
        memberRepository.save(new Member("Charlie.Charlie@gmail.com", "Charlie", "Charlie"));
        memberRepository.save(new Member("Duff.Don@gmail.com", "Duff", "Don"));
        memberRepository.save(new Member("Edward.Edward@gmail.com", "Edward", "Edward"));
        memberRepository.save(new Member("Freddy.Freddie@gmail.com", "Freddy", "Freddie"));
        memberRepository.save(new Member("George.Gee@gmail.com", "George", "Gee"));
        memberRepository.save(new Member("Harry.Harry@gmail.com", "Harry", "Harry"));
        memberRepository.save(new Member("Ink.India@gmail.com", "Ink", "India"));
        memberRepository.save(new Member("Johnnie.Johnnie@gmail.com", "Johnnie", "Johnnie"));
        memberRepository.save(new Member("King.King@gmail.com", "King", "King"));
        memberRepository.save(new Member("London.London@gmail.com", "London", "London"));
        memberRepository.save(new Member("Monkey.Emma@gmail.com", "Monkey", "Emma"));
        memberRepository.save(new Member("Nuts.Nuts@gmail.com", "Nuts", "Nuts"));
        memberRepository.save(new Member("Orange.Orange@gmail.com", "Orange", "Orange"));
        memberRepository.save(new Member("Pudding.Paris@gmail.com", "Pudding", "Paris"));
        memberRepository.save(new Member("Queenie.Queen@gmail.com", "Queenie", "Queen"));
        memberRepository.save(new Member("Robert.Robert@gmail.com", "Robert", "Robert"));
        memberRepository.save(new Member("Sugar.Esses@gmail.com", "Sugar", "Esses"));
        memberRepository.save(new Member("Tommy.Toc@gmail.com", "Tommy", "Toc"));
        memberRepository.save(new Member("Uncle.Uncle@gmail.com", "Uncle", "Uncle"));
        memberRepository.save(new Member("Vinegar.Vic@gmail.com", "Vinegar", "Vic"));
        memberRepository.save(new Member("Willie.William@gmail.com", "willie", "William"));
        memberRepository.save(new Member("Xerxes.Xanthippe@gmail.com", "Xerxes", "Xanthippe"));
        memberRepository.save(new Member("Yellow.Yorker@gmail.com", "Yellow", "Yorker"));
        memberRepository.save(new Member("Zebra.Zurich@gmail.com", "Zebra", "Zurich"));
    }
}
