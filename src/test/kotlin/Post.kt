


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

    val post = Post(id = 0,owner_id = 1,from_id = 1,created_by = 5,date = 1234231,text = "Текст записи..",
                    reply_owner_id = 46,reply_post_id = 456,friends_only = false,post_type = "post",
                    signer_id = 1,can_pin = true,can_delete = true,can_edit = true,is_pinned = false,
                    marked_as_ads = false,is_favorite = false,postponed_id = 0)
    println(WallService.add(post))

    val vId = 0
    val post2 = Post(id = vId,owner_id = 1,from_id = 1,created_by = 5,date = 1234231,text = "измененный текст записи..",
        reply_owner_id = 46,reply_post_id = 456,friends_only = false,post_type = "post",
        signer_id = 1,can_pin = true,can_delete = true,can_edit = true,is_pinned = false,
        marked_as_ads = false,is_favorite = false,postponed_id = 0)

    if (WallService.update(post2)) println("Пост под номером $vId был успешно изменен")
    else println("Не удалось изменить пост под номером $vId")


}



