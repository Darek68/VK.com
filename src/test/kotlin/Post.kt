


data class Post(
    var id: Int,
    val owner_id: Int,   // идентификатор владельца стены, на которой размещена запись
    val from_id: Int,    // идентификатор автора записи
    val created_by: Int, // идентификатор администратора, который опубликовал запись
    val date: Long,
    val text: String,
    val reply_owner_id: Int, //идентификатор владельца записи, в ответ на которую была оставлена текущая
    val reply_post_id: Int,  //идентификатор записи, в ответ на которую была оставлена текущая
    val friends_only: Boolean, //запись была создана с опцией «Только для друзей»
    val post_type: String, //тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signer_id: Int,    //идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    val can_pin: Boolean,  //может ли текущий пользователь закрепить запись
    val can_delete: Boolean, //может ли текущий пользователь удалить запись
    val can_edit: Boolean,   //может ли текущий пользователь редактировать запись
    val is_pinned: Boolean,  //запись закреплена?
    val marked_as_ads: Boolean, //содержит ли запись отметку "реклама"
    val is_favorite: Boolean,  //объект добавлен в закладки у текущего пользователя
    val postponed_id: Long,    //идентификатор отложенной записи - таймер
)

fun main() {
    val vId = 0
    val post = Post(id = vId,owner_id = 1,from_id = 1,created_by = 5,date = 1234231,text = "Текст записи..",
                    reply_owner_id = 46,reply_post_id = 456,friends_only = false,post_type = "post",
                    signer_id = 1,can_pin = true,can_delete = true,can_edit = true,is_pinned = false,
                    marked_as_ads = false,is_favorite = false,postponed_id = 0)
    println("Будет создан пост..")
    println(WallService.add(post))

    val post2 = Post(id = vId,owner_id = 1,from_id = 1,created_by = 5,date = 1234231,text = "измененный текст записи..",
        reply_owner_id = 46,reply_post_id = 456,friends_only = false,post_type = "post",
        signer_id = 1,can_pin = true,can_delete = true,can_edit = true,is_pinned = false,
        marked_as_ads = false,is_favorite = false,postponed_id = 0)
    println("Попытка апдейта поста номер $vId")
    println(updPost(post2))

    val vIdNew = 1000
    val post3 = Post(id = vIdNew,owner_id = 10,from_id = 11,created_by = 51,date = 121231,text = "совсем новый текст ..",
        reply_owner_id = 46,reply_post_id = 456,friends_only = false,post_type = "post",
        signer_id = 1,can_pin = true,can_delete = true,can_edit = true,is_pinned = false,
        marked_as_ads = false,is_favorite = false,postponed_id = 0)
    println("Попытка апдейта поста номер $vIdNew")
    println(updPost(post3))
}

fun updPost(post:Post):String{
    val vId = post.id
    return if (WallService.update(post)) "Пост под номером $vId был успешно изменен"
                                    else "Не удалось изменить пост под номером $vId"
}



