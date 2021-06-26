



interface Media {
    val id : Int
    val album_id : Int
    val owner_id : Int
    val user_id : Int
}

class Attachment(val id : Int,val media : Media)

// класс поля медиавложений
class Attachments {
    var attachments = emptyArray<Attachment>()

    fun add(attachment: Attachment): Attachment{
        attachments += attachment
        return attachments.last()
    }
}

class Photo(
    override val id: Int,
    override val album_id: Int,
    override val owner_id: Int,
    override val user_id: Int
) : Media

class Video(
    override val id: Int,
    override val album_id: Int,
    override val owner_id: Int,
    override val user_id: Int
) : Media

class Pictures(
    override val id: Int,
    override val album_id: Int,
    override val owner_id: Int,
    override val user_id: Int
) : Media

class Docum(
    override val id: Int,
    override val album_id: Int,
    override val owner_id: Int,
    override val user_id: Int
) : Media