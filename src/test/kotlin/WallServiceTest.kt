import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    val objCopyright = Copyright()
    val objReposts = Reposts()
    val objViews = Views()

    val post = Post(
        id = 0,ownerId = 1,fromId = 1,createdBy = 5,date = 1234231,text = "Текст записи..",
        replyOwnerId = 46,replyPostId = 456,friendsOnly = false,
        copyright = objCopyright,reposts = objReposts,views = null,
        postType = "post",attachments = null,signerId = 1,canPin = true,canDelete = true,canEdit = true,isPinned = false,
        markedAsAds = false,isFavorite = false,postponedId = 0
    )

    @Test
    fun addTest() {
        //arrange
        val service = WallService()
        service.add(post.copy(text = "Второй текст записи.."))
        service.add(post.copy(text = "Третий текст записи..",views = Views()))
        //act
        val testPost = post.copy(text = "Проверочный текст записи..")
        val result = service.add(testPost)
        //assert
        assertEquals(testPost.copy(id=2), result)

        //val result = service.add(post.copy(text = "Проверочный текст записи..")).id
        //assertEquals(false, result == 0)
        // assertFalse(result == 0)
        // assertNotEquals(0,result)
    }

    @Test
    fun updateExistingTest() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(post)
        service.add(post.copy(text = "Второй текст записи.."))
        service.add(post.copy(text = "Третий текст записи..",reposts = objReposts))
        // создаём информацию об обновлении
        val update = post.copy(id = 2,text = "Третий текст записи..",copyright = objCopyright)

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