
val service = WallService()


data class Post(
    var id: Int,
    val ownerId: Int,   // идентификатор владельца стены, на которой размещена запись
    val fromId: Int,    // идентификатор автора записи
    val createdBy: Int, // идентификатор администратора, который опубликовал запись
    val date: Long,
    val text: String,
    val replyOwnerId: Int, //идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int,  //идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean, //запись была создана с опцией «Только для друзей»
    val copyright: Copyright?, // источник материала
    val reposts: Reposts?, //информация о репостах записи
    val views: Views?,  //информация о просмотрах записи
    val postType: String, //тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val attachments: Attachments?, //медиавложения
    val signerId: Int,    //идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    val canPin: Boolean,  //может ли текущий пользователь закрепить запись
    val canDelete: Boolean, //может ли текущий пользователь удалить запись
    val canEdit: Boolean,   //может ли текущий пользователь редактировать запись
    val isPinned: Boolean,  //запись закреплена?
    val markedAsAds: Boolean, //содержит ли запись отметку "реклама"
    val isFavorite: Boolean,  //объект добавлен в закладки у текущего пользователя
    val postponedId: Long,    //идентификатор отложенной записи - таймер
)

// источник материала
class Copyright {
    val id   = 0
    val link = ""
    val name = ""
    val type = ""
}
//информация о репостах записи
class Reposts {
    val count   = 0
    val userReposted = false
}
//информация о просмотрах записи
class Views {
    val count   = 0
}


fun main() {

    val objCopyright = Copyright()
    val objReposts = Reposts()
    val objViews = Views()
    val vId = 0
    val post = Post(id = vId,ownerId = 1,fromId = 1,createdBy = 5,date = 1234231,text = "Текст записи..",
                    replyOwnerId = 46,replyPostId = 456,friendsOnly = false,
                    copyright = objCopyright,reposts = objReposts,views = null,
                    postType = "post",attachments = null,signerId = 1,canPin = true,canDelete = true,canEdit = true,isPinned = false,
                    markedAsAds = false,isFavorite = false,postponedId = 0)
    println("Будет создан пост..")
    println(service.add(post))

    val post2 = Post(id = vId,ownerId = 1,fromId = 1,createdBy = 5,date = 1234231,text = "измененный текст записи..",
        replyOwnerId = 46,replyPostId = 456,friendsOnly = false,
        copyright = objCopyright,reposts = objReposts,views = objViews,
        postType = "post",attachments = null,signerId = 1,canPin = true,canDelete = true,canEdit = true,isPinned = false,
        markedAsAds = false,isFavorite = false,postponedId = 0)
    println("Попытка апдейта поста номер $vId")
    println(updPost(post2))

    val vIdNew = 1000
    val post3 = Post(id = vIdNew,ownerId = 10,fromId = 11,createdBy = 51,date = 121231,text = "совсем новый текст ..",
        replyOwnerId = 46,replyPostId = 456,friendsOnly = false,
        copyright = objCopyright,reposts = objReposts,views = objViews,
        postType = "post",attachments = null,signerId = 1,canPin = true,canDelete = true,canEdit = true,isPinned = false,
        markedAsAds = false,isFavorite = false,postponedId = 0)
    println("Попытка апдейта поста номер $vIdNew")
    println(updPost(post3))
}

fun updPost(post:Post):String{
    val vId = post.id
    return if (service.update(post)) "Пост под номером $vId был успешно изменен"
                                    else "Не удалось изменить пост под номером $vId"
}



