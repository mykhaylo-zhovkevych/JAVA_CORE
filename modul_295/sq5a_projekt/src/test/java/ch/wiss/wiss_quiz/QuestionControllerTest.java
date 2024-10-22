package ch.wiss.wiss_quiz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


import java.util.Collections;
import java.util.Optional;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ch.wiss.wiss_quiz.controller.QuestionController;
import ch.wiss.wiss_quiz.model.AnswerRepository;
import ch.wiss.wiss_quiz.model.Category;
import ch.wiss.wiss_quiz.model.CategoryRepository;
import ch.wiss.wiss_quiz.model.Question;
import ch.wiss.wiss_quiz.model.QuestionRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(QuestionController.class)
@AutoConfigureMockMvc
public class QuestionControllerTest {
    
    @MockBean private QuestionRepository questionRepository;
    @MockBean private CategoryRepository categoryRepository;
    @MockBean private AnswerRepository answerRepository;

    @Autowired private MockMvc mockMvc;


    @Test
    public void whenQuestionControllerInjected_thenNotNull() throws Exception {
        assertThat(questionRepository).isNotNull();
    }

    // Test für die Lesefunktion (GET /question)
    @Test 
    public void whenGetAllQuestions_thenReturnQuestions() throws Exception {

        Question question = new Question();
        question.setId(1);
        question.setQuestion("Was ist das, mein Freund");

        when(questionRepository.findAll()).thenReturn(Collections.singletonList(question));

        mockMvc.perform(MockMvcRequestBuilders.get("/question"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].question").value("Was ist das, mein Freund"));


    }

    @Test
    public void whenPostNewQuestions_withValidData_thenResponseOk() throws Exception {
    // Set up category and mock repository behavior
    Category category = new Category();
    category.setId(1);
    category.setName("Test Kategorie");

    when(categoryRepository.findById(1)).thenReturn(Optional.of(category));

    // Create valid question JSON
    String questionJson = "{\"question\":\"Was ist das, mein Freund\", \"answers\":[{\"answer\":\"Antwort 1\"}, {\"answer\":\"Antwort 2\"}]}";

    // Perform the POST request with valid data
    mockMvc.perform(MockMvcRequestBuilders.post("/question/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(questionJson))
            .andExpect(MockMvcResultMatchers.status().isOk() )
            .andExpect(MockMvcResultMatchers.content().string("Saved"));
}





}
