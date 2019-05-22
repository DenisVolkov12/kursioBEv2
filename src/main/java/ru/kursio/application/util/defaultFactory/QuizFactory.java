package ru.kursio.application.util.defaultFactory;

import ru.kursio.application.model.entity.customization.renat.ColorQuizAnswer;
import ru.kursio.application.model.entity.customization.renat.ColorQuizQuestion;

import java.util.*;

public class QuizFactory {

    private final String QUESTION_1_TO_30 = "From the options listed, choose one which describes your personality in childhood";
    public List<ColorQuizQuestion> createQuiz(String type){

        if(type.equals("RENAT_COLOR_QUIZ")) {
            ColorQuizQuestion q1 = new ColorQuizQuestion();
            q1.setQuestion(QUESTION_1_TO_30);
            q1.setAnswers(generateSetOfAnswerRenat(1));

            ColorQuizQuestion q2 = new ColorQuizQuestion();
            q2.setQuestion(QUESTION_1_TO_30);
            q2.setAnswers(generateSetOfAnswerRenat(2));

            ColorQuizQuestion q3 = new ColorQuizQuestion();
            q3.setQuestion(QUESTION_1_TO_30);
            q3.setAnswers(generateSetOfAnswerRenat(3));

            ColorQuizQuestion q4 = new ColorQuizQuestion();
            q4.setQuestion(QUESTION_1_TO_30);
            q4.setAnswers(generateSetOfAnswerRenat(4));

            ColorQuizQuestion q5 = new ColorQuizQuestion();
            q5.setQuestion(QUESTION_1_TO_30);
            q5.setAnswers(generateSetOfAnswerRenat(5));

            ColorQuizQuestion q6 = new ColorQuizQuestion();
            q6.setQuestion(QUESTION_1_TO_30);
            q6.setAnswers(generateSetOfAnswerRenat(6));

            ColorQuizQuestion q7 = new ColorQuizQuestion();
            q7.setQuestion(QUESTION_1_TO_30);
            q7.setAnswers(generateSetOfAnswerRenat(7));

            ColorQuizQuestion q8 = new ColorQuizQuestion();
            q8.setQuestion(QUESTION_1_TO_30);
            q8.setAnswers(generateSetOfAnswerRenat(8));

            ColorQuizQuestion q9 = new ColorQuizQuestion();
            q9.setQuestion(QUESTION_1_TO_30);
            q9.setAnswers(generateSetOfAnswerRenat(9));

            ColorQuizQuestion q10 = new ColorQuizQuestion();
            q10.setQuestion(QUESTION_1_TO_30);
            q10.setAnswers(generateSetOfAnswerRenat(10));

            ColorQuizQuestion q11 = new ColorQuizQuestion();
            q11.setQuestion(QUESTION_1_TO_30);
            q11.setAnswers(generateSetOfAnswerRenat(11));

            ColorQuizQuestion q12 = new ColorQuizQuestion();
            q12.setQuestion(QUESTION_1_TO_30);
            q12.setAnswers(generateSetOfAnswerRenat(12));

            ColorQuizQuestion q13 = new ColorQuizQuestion();
            q13.setQuestion(QUESTION_1_TO_30);
            q13.setAnswers(generateSetOfAnswerRenat(13));

            ColorQuizQuestion q14 = new ColorQuizQuestion();
            q14.setQuestion(QUESTION_1_TO_30);
            q14.setAnswers(generateSetOfAnswerRenat(14));

            ColorQuizQuestion q15 = new ColorQuizQuestion();
            q15.setQuestion(QUESTION_1_TO_30);
            q15.setAnswers(generateSetOfAnswerRenat(15));

            ColorQuizQuestion q16 = new ColorQuizQuestion();
            q16.setQuestion(QUESTION_1_TO_30);
            q16.setAnswers(generateSetOfAnswerRenat(16));

            ColorQuizQuestion q17 = new ColorQuizQuestion();
            q17.setQuestion(QUESTION_1_TO_30);
            q17.setAnswers(generateSetOfAnswerRenat(17));

            ColorQuizQuestion q18 = new ColorQuizQuestion();
            q18.setQuestion(QUESTION_1_TO_30);
            q18.setAnswers(generateSetOfAnswerRenat(18));

            ColorQuizQuestion q19 = new ColorQuizQuestion();
            q19.setQuestion(QUESTION_1_TO_30);
            q19.setAnswers(generateSetOfAnswerRenat(19));

            ColorQuizQuestion q20 = new ColorQuizQuestion();
            q20.setQuestion(QUESTION_1_TO_30);
            q20.setAnswers(generateSetOfAnswerRenat(20));

            ColorQuizQuestion q21 = new ColorQuizQuestion();
            q21.setQuestion(QUESTION_1_TO_30);
            q21.setAnswers(generateSetOfAnswerRenat(21));

            ColorQuizQuestion q22 = new ColorQuizQuestion();
            q22.setQuestion(QUESTION_1_TO_30);
            q22.setAnswers(generateSetOfAnswerRenat(22));

            ColorQuizQuestion q23 = new ColorQuizQuestion();
            q23.setQuestion(QUESTION_1_TO_30);
            q23.setAnswers(generateSetOfAnswerRenat(23));

            ColorQuizQuestion q24 = new ColorQuizQuestion();
            q24.setQuestion(QUESTION_1_TO_30);
            q24.setAnswers(generateSetOfAnswerRenat(24));

            ColorQuizQuestion q25 = new ColorQuizQuestion();
            q25.setQuestion(QUESTION_1_TO_30);
            q25.setAnswers(generateSetOfAnswerRenat(25));

            ColorQuizQuestion q26 = new ColorQuizQuestion();
            q26.setQuestion(QUESTION_1_TO_30);
            q26.setAnswers(generateSetOfAnswerRenat(26));

            ColorQuizQuestion q27 = new ColorQuizQuestion();
            q27.setQuestion(QUESTION_1_TO_30);
            q27.setAnswers(generateSetOfAnswerRenat(27));

            ColorQuizQuestion q28 = new ColorQuizQuestion();
            q28.setQuestion(QUESTION_1_TO_30);
            q28.setAnswers(generateSetOfAnswerRenat(28));

            ColorQuizQuestion q29 = new ColorQuizQuestion();
            q29.setQuestion(QUESTION_1_TO_30);
            q29.setAnswers(generateSetOfAnswerRenat(29));

            ColorQuizQuestion q30 = new ColorQuizQuestion();
            q30.setQuestion(QUESTION_1_TO_30);
            q30.setAnswers(generateSetOfAnswerRenat(30));

            return new ArrayList<>(Arrays.asList(q1, q2, q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,
                    q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24,q25,q26,q27,q28,q29,q30));
        }
        return null;
    }

    private Set<ColorQuizAnswer> generateSetOfAnswerRenat(int questionNumber){
        Set createdSet = new HashSet();
        switch(questionNumber) {
            case 1:
                ColorQuizAnswer a1 = createColorQuizAnswer("proactive", "red", "positive");
                ColorQuizAnswer a2 = createColorQuizAnswer("nurturing", "blue", "positive");
                ColorQuizAnswer a3 = createColorQuizAnswer("objective", "white", "positive");
                ColorQuizAnswer a4 = createColorQuizAnswer("insightful", "yellow", "positive");
                return new HashSet<>(Arrays.asList(a1, a2, a3, a4));
                
            case 2:
                ColorQuizAnswer a5 = createColorQuizAnswer("indecisive", "white", "negative");
                ColorQuizAnswer a6 = createColorQuizAnswer("arrogant", "red", "negative");
                ColorQuizAnswer a7 = createColorQuizAnswer("a perfectionist", "blue", "negative");
                ColorQuizAnswer a8 = createColorQuizAnswer("poor follow through", "yellow", "negative");
                return new HashSet<>(Arrays.asList(a5, a6, a7, a8));
                
            case 3:
                ColorQuizAnswer a9 = createColorQuizAnswer("enthusiastic", "yellow", "positive");
                ColorQuizAnswer a10 = createColorQuizAnswer("kind", "white", "positive");
                ColorQuizAnswer a11 = createColorQuizAnswer("caring", "blue", "positive");
                ColorQuizAnswer a12 = createColorQuizAnswer("productive", "red", "positive");
                return new HashSet<>(Arrays.asList(a9, a10, a11, a12));
                
            case 4:
                ColorQuizAnswer a13 = createColorQuizAnswer("relentless", "red", "negative");
                ColorQuizAnswer a14 = createColorQuizAnswer("suspicious", "blue", "negative");
                ColorQuizAnswer a15 = createColorQuizAnswer("indifferent", "white", "negative");
                ColorQuizAnswer a16 = createColorQuizAnswer("naive", "yellow", "negative");
                return new HashSet<>(Arrays.asList(a13, a14, a15, a16));
                
            case 5:
                ColorQuizAnswer a17 = createColorQuizAnswer("peaceful", "white", "positive");
                ColorQuizAnswer a18 = createColorQuizAnswer("carefree", "yellow", "positive");
                ColorQuizAnswer a19 = createColorQuizAnswer("decisive", "red", "positive");
                ColorQuizAnswer a20 = createColorQuizAnswer("loyal", "blue", "positive");
                return new HashSet<>(Arrays.asList(a17, a18, a19, a20));
                
            case 6:
                ColorQuizAnswer a21 = createColorQuizAnswer("silently stubborn", "white", "negative");
                ColorQuizAnswer a22 = createColorQuizAnswer("worry prone", "blue", "negative");
                ColorQuizAnswer a23 = createColorQuizAnswer("an interupter", "yellow", "negative");
                ColorQuizAnswer a24 = createColorQuizAnswer("obsessive", "red", "negative");
                return new HashSet<>(Arrays.asList(a21, a22, a23, a24));
                
            case 7:
                ColorQuizAnswer a25 = createColorQuizAnswer("sociable", "yellow", "positive");
                ColorQuizAnswer a26 = createColorQuizAnswer("assertive", "red", "positive");
                ColorQuizAnswer a27 = createColorQuizAnswer("intimate", "blue", "positive");
                ColorQuizAnswer a28 = createColorQuizAnswer("non-discriminate", "white", "positive");
                return new HashSet<>(Arrays.asList(a25, a26, a27, a28));
                
            case 8:
                ColorQuizAnswer a29 = createColorQuizAnswer("self-critical", "blue", "negative");
                ColorQuizAnswer a30 = createColorQuizAnswer("bossy", "red", "negative");
                ColorQuizAnswer a31 = createColorQuizAnswer("unfocused", "yellow", "negative");
                ColorQuizAnswer a32 = createColorQuizAnswer("avoids conflict", "white", "negative");
                return new HashSet<>(Arrays.asList(a29, a30, a31, a32));
                
            case 9:
                ColorQuizAnswer a33 = createColorQuizAnswer("voice of reason", "white", "positive");
                ColorQuizAnswer a34 = createColorQuizAnswer("flexible", "yellow", "positive");
                ColorQuizAnswer a35 = createColorQuizAnswer("action-oriented", "red", "positive");
                ColorQuizAnswer a36 = createColorQuizAnswer("analytical", "blue", "positive");
                return new HashSet<>(Arrays.asList(a33, a34, a35, a36));
                
            case 10:
                ColorQuizAnswer a37 = createColorQuizAnswer("critical of others", "red", "negative");
                ColorQuizAnswer a38 = createColorQuizAnswer("disinterested", "white", "negative");
                ColorQuizAnswer a39 = createColorQuizAnswer("overly sensitive", "blue", "negative");
                ColorQuizAnswer a40 = createColorQuizAnswer("irresponsible", "yellow", "negative");
                return new HashSet<>(Arrays.asList(a37, a38, a39, a40));
            
            case 11:
                ColorQuizAnswer a41 = createColorQuizAnswer("determined", "red", "positive");
                ColorQuizAnswer a42 = createColorQuizAnswer("thoughtful", "blue", "positive");
                ColorQuizAnswer a43 = createColorQuizAnswer("a good listener", "white", "positive");
                ColorQuizAnswer a44 = createColorQuizAnswer("trusting", "yellow", "positive");
                return new HashSet<>(Arrays.asList(a41, a42, a43, a44));
                
            case 12:
                ColorQuizAnswer a45 = createColorQuizAnswer("lazy", "white", "negative");
                ColorQuizAnswer a46 = createColorQuizAnswer("vain", "yellow", "negative");
                ColorQuizAnswer a47 = createColorQuizAnswer("demanding", "red", "negative");
                ColorQuizAnswer a48 = createColorQuizAnswer("unforgiving", "blue", "negative");
                return new HashSet<>(Arrays.asList(a45, a46, a47, a48));
                
            case 13:
                ColorQuizAnswer a49 = createColorQuizAnswer("happy", "yellow", "positive");
                ColorQuizAnswer a50 = createColorQuizAnswer("compasionate", "blue", "positive");
                ColorQuizAnswer a51 = createColorQuizAnswer("inventive", "white", "positive");
                ColorQuizAnswer a52 = createColorQuizAnswer("responsible", "red", "positive");
                return new HashSet<>(Arrays.asList(a49, a50, a51, a52));
                
            case 14:
                ColorQuizAnswer a53 = createColorQuizAnswer("impulsive", "yellow", "negative");
                ColorQuizAnswer a54 = createColorQuizAnswer("impatient", "red", "negative");
                ColorQuizAnswer a55 = createColorQuizAnswer("moody", "blue", "negative");
                ColorQuizAnswer a56 = createColorQuizAnswer("indirect communicator", "white", "negative");
                return new HashSet<>(Arrays.asList(a53, a54, a55, a56));
                
            case 15:
                ColorQuizAnswer a57 = createColorQuizAnswer("a leader", "red", "positive");
                ColorQuizAnswer a58 = createColorQuizAnswer("patient", "white", "positive");
                ColorQuizAnswer a59 = createColorQuizAnswer("fun-loving", "yellow", "positive");
                ColorQuizAnswer a60 = createColorQuizAnswer("respectful", "blue", "positive");
                return new HashSet<>(Arrays.asList(a57, a58, a59, a60));
                
            case 16:
                ColorQuizAnswer a61 = createColorQuizAnswer("jealous", "blue", "negative");
                ColorQuizAnswer a62 = createColorQuizAnswer("reluctant", "white", "negative");
                ColorQuizAnswer a63 = createColorQuizAnswer("argumentative", "red", "negative");
                ColorQuizAnswer a64 = createColorQuizAnswer("obnoxious", "yellow", "negative");
                return new HashSet<>(Arrays.asList(a61, a62, a63, a64));
                
            case 17:
                ColorQuizAnswer a65 = createColorQuizAnswer("even-tempered", "white", "positive");
                ColorQuizAnswer a66 = createColorQuizAnswer("engaging", "yellow", "positive");
                ColorQuizAnswer a67 = createColorQuizAnswer("dependable", "blue", "positive");
                ColorQuizAnswer a68 = createColorQuizAnswer("focused", "red", "positive");
                return new HashSet<>(Arrays.asList(a65, a66, a67, a68));
                
            case 18:
                ColorQuizAnswer a69 = createColorQuizAnswer("overly aggressive", "red", "negative");
                ColorQuizAnswer a70 = createColorQuizAnswer("low self-esteem", "blue", "negative");
                ColorQuizAnswer a71 = createColorQuizAnswer("ambivalent", "white", "negative");
                ColorQuizAnswer a72 = createColorQuizAnswer("inconsistent", "yellow", "negative");
                return new HashSet<>(Arrays.asList(a69, a70, a71, a72));
                
            case 19:
                ColorQuizAnswer a73 = createColorQuizAnswer("deliberate", "blue", "positive");
                ColorQuizAnswer a74 = createColorQuizAnswer("powerful", "red", "positive");
                ColorQuizAnswer a75 = createColorQuizAnswer("balanced", "white", "positive");
                ColorQuizAnswer a76 = createColorQuizAnswer("persuasive", "yellow", "positive");
                return new HashSet<>(Arrays.asList(a73, a74, a75, a76));
                
            case 20:
                ColorQuizAnswer a77 = createColorQuizAnswer("undisciplined", "yellow", "negative");
                ColorQuizAnswer a78 = createColorQuizAnswer("timid", "white", "negative");
                ColorQuizAnswer a79 = createColorQuizAnswer("insensitive", "red", "negative");
                ColorQuizAnswer a80 = createColorQuizAnswer("judgmental", "blue", "negative");
                return new HashSet<>(Arrays.asList(a77, a78, a79, a80));
                
            case 21:
                ColorQuizAnswer a81 = createColorQuizAnswer("playful", "yellow", "positive");
                ColorQuizAnswer a82 = createColorQuizAnswer("clear perspective", "white", "positive");
                ColorQuizAnswer a83 = createColorQuizAnswer("detail conscious", "blue", "positive");
                ColorQuizAnswer a84 = createColorQuizAnswer("clear perspective", "red", "positive");
                return new HashSet<>(Arrays.asList(a81, a82, a83, a84));
                
            case 22:
                ColorQuizAnswer a85 = createColorQuizAnswer("always right", "red", "negative");
                ColorQuizAnswer a86 = createColorQuizAnswer("uncommitted", "yellow", "negative");
                ColorQuizAnswer a87 = createColorQuizAnswer("uninvolved", "white", "negative");
                ColorQuizAnswer a88 = createColorQuizAnswer("guilt prone", "blue", "negative");
                return new HashSet<>(Arrays.asList(a85, a86, a87, a88));
                
            case 23:
                ColorQuizAnswer a89 = createColorQuizAnswer("accepting", "white", "positive");
                ColorQuizAnswer a90 = createColorQuizAnswer("spontaneous", "yellow", "positive");
                ColorQuizAnswer a91 = createColorQuizAnswer("pragmatic", "red", "positive");
                ColorQuizAnswer a92 = createColorQuizAnswer("well-mannered", "blue", "positive");
                return new HashSet<>(Arrays.asList(a89, a90, a91, a92));
                
            case 24:
                ColorQuizAnswer a93 = createColorQuizAnswer("disorganized", "yellow", "negative");
                ColorQuizAnswer a94 = createColorQuizAnswer("selfish", "red", "negative");
                ColorQuizAnswer a95 = createColorQuizAnswer("emotionaly intense", "blue", "negative");
                ColorQuizAnswer a96 = createColorQuizAnswer("detached", "white", "negative");
                return new HashSet<>(Arrays.asList(a93, a94, a95, a96));
                
            case 25:
                ColorQuizAnswer a97 = createColorQuizAnswer("motivated", "red", "positive");
                ColorQuizAnswer a98 = createColorQuizAnswer("sincere", "blue", "positive");
                ColorQuizAnswer a99 = createColorQuizAnswer("diplomatic", "white", "positive");
                ColorQuizAnswer a100 = createColorQuizAnswer("engaging of others", "yellow", "positive");
                return new HashSet<>(Arrays.asList(a97, a98, a99, a100));
                
            case 26:
                ColorQuizAnswer a101 = createColorQuizAnswer("forgetful", "yellow", "negative");
                ColorQuizAnswer a102 = createColorQuizAnswer("boring", "white", "negative");
                ColorQuizAnswer a103 = createColorQuizAnswer("hard to please", "blue", "negative");
                ColorQuizAnswer a104 = createColorQuizAnswer("tactless", "red", "negative");
                return new HashSet<>(Arrays.asList(a101, a102, a103, a104));
                
            case 27:
                ColorQuizAnswer a105 = createColorQuizAnswer("articulate", "red", "positive");
                ColorQuizAnswer a106 = createColorQuizAnswer("quality-oriented", "blue", "positive");
                ColorQuizAnswer a107 = createColorQuizAnswer("centered", "white", "positive");
                ColorQuizAnswer a108 = createColorQuizAnswer("forgiving", "yellow", "positive");
                return new HashSet<>(Arrays.asList(a105, a106, a107, a108));
                
            case 28:
                ColorQuizAnswer a109 = createColorQuizAnswer("self-centered", "yellow", "negative");
                ColorQuizAnswer a110 = createColorQuizAnswer("calculating", "red", "negative");
                ColorQuizAnswer a111 = createColorQuizAnswer("self-righteous", "blue", "negative");
                ColorQuizAnswer a112 = createColorQuizAnswer("unexpressive", "white", "negative");
                return new HashSet<>(Arrays.asList(a109, a110, a111, a112));
                
            case 29:
                ColorQuizAnswer a113 = createColorQuizAnswer("self-regulated", "white", "positive");
                ColorQuizAnswer a114 = createColorQuizAnswer("charismatic", "yellow", "positive");
                ColorQuizAnswer a115 = createColorQuizAnswer("confident", "red", "positive");
                ColorQuizAnswer a116 = createColorQuizAnswer("intuitive", "blue", "positive");
                return new HashSet<>(Arrays.asList(a113, a114, a115, a116));
                
            case 30:
                ColorQuizAnswer a117 = createColorQuizAnswer("unrealistic expectations", "blue", "negative");
                ColorQuizAnswer a118 = createColorQuizAnswer("unproductive", "white", "negative");
                ColorQuizAnswer a119 = createColorQuizAnswer("afraid to face facts", "yellow", "negative");
                ColorQuizAnswer a120 = createColorQuizAnswer("intimidating", "red", "negative");
                return new HashSet<>(Arrays.asList(a117, a118, a119, a120));
                
        }
        return null;
//
//        ColorQuizAnswer a117 = createColorQuizAnswer("");
//        ColorQuizAnswer a118 = createColorQuizAnswer("");
//        ColorQuizAnswer a119 = createColorQuizAnswer("");
//        ColorQuizAnswer a120 = createColorQuizAnswer("");


    }

    private ColorQuizAnswer createColorQuizAnswer (String answer, String color, String direction){
        ColorQuizAnswer newAnswer = new ColorQuizAnswer();
        newAnswer.setAnswer(answer);
        newAnswer.setColor(color);
        newAnswer.setDirection(direction);
        return newAnswer;
    }
}
