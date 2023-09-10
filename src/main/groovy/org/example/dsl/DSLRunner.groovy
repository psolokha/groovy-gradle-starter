package org.example.dsl

import static org.example.dsl.DSLBuilder.*
/**
    def email = new Email()
    email.setFrom("from@mail.ru")
    email.setTo("to@mail.ru")
    email.setTitle("title")

    def body = new EmailBody()
    body.setText("some text")
    body.setImages(List.of("image.jpg"))
    email.setBody(body)
 */

//builder pattern
mail {
    from "from@mail.ru"
    to "to@mail.ru"
    title "title"
    body {
        text "some text"
        images (['image.jpg', 'image2.png'])
    }
}
