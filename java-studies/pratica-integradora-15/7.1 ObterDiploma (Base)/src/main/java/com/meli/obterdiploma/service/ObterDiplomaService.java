package com.meli.obterdiploma.service;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObterDiplomaService implements IObterDiplomaService {

    @Override
    public StudentDTO analyzeScores(StudentDTO rq) {
        rq.setAverageScore(calculateAverage(rq.getSubjects()));
        rq.setMessage(getGreetingMessage(rq.getStudentName(), rq.getAverageScore()));

        return rq;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "O aluno " + studentName + " obteve uma média de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Parabéns!" : ". Você pode ficar melhor.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }
}
