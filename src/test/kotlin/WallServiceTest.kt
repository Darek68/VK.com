import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    val post = Post(
        id = 0, owner_id = 1, from_id = 1, created_by = 5, date = 1234231, text = "Текст записи..",
        reply_owner_id = 46, reply_post_id = 456, friends_only = false, post_type = "post",
        signer_id = 1, can_pin = true, can_delete = true, can_edit = true, is_pinned = false,
        marked_as_ads = false, is_favorite = false, postponed_id = 0,
    )

    @Test
    fun addTest() {
        //arrange
        val service = WallService()
        service.add(post.copy(text = "Второй текст записи.."))
        service.add(post.copy(text = "Третий текст записи.."))
        //act
        val result = service.add(post.copy(text = "Проверочный текст записи..")).id
        //assert
       // assertFalse(result == 0)
        assertEquals(false, result == 0)
       // assertNotEquals(0,result)
    }

    @Test
    fun updateExistingTest() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(post)
        service.add(post.copy(text = "Второй текст записи.."))
        service.add(post.copy(text = "Третий текст записи.."))
        // создаём информацию об обновлении
        val update = post.copy(id = 2,text = "Третий текст записи..")

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }
    @Test
    fun updateNotExistingTest() {
        //arrange
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(post)
        service.add(post.copy(text = "Второй текст записи.."))
        service.add(post.copy(text = "Третий текст записи.."))
        // создаём информацию об обновлении
        val update = post.copy(id = 100,text = "Измененный текст записи..")
        //act
        // выполняем целевое действие
        val result = service.update(update)
        //assert
        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }
}

/*
 на add - всего один, который проверяет, что после добавления поста id стал не равным 0
на update - целых два:
изменяем пост с существующим id, возвращается true
изменяем пост с несуществующим id, возвращается false
 */