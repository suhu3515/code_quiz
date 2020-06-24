package com.vhddev.codequiz;

import android.widget.Button;

interface Answers {

    void enableNext();
    void right_ans(Button button);
    void wrong_ans(Button button1, Button button2);
    void buttonDisable(Button button1, Button button2, Button button3);
    void increase_score();
    void show_score();
    void next_question();
    void exit_prompt();

}
