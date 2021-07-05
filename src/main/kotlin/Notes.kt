

interface CrudService<T>{
    fun add(element: T)
    fun del(element: T)
    fun get(id:Int):T?
    fun edit(element: T)
}



class NotesService: CrudService<Note>{

    override fun add(element: Note) {
        element.id = notes.size + 1
        notes.plusAssign(element)
    }

    override fun del(element: Note) {
        notes.remove(element)
        //notes.removeAt(notes.indexOf(element))
    }

    override fun get(id: Int): Note? {
        for ((index, note) in notes.withIndex()){
            if (note.id == id) {
                return notes.get(index)
            }
        }
        return null
    }

    override fun edit(element: Note) {
        val vId = element.id
        for ((index, note) in notes.withIndex()){
            if (note.id == vId) {
                notes.get(index).text = element.text
            }
        }
    }

}
var notes: MutableList<Note> = emptyList<Note>() as MutableList<Note>

class Note (var title: String,var text: String,val comments:List<Comment>){
    var id:Int = 0
    // val comments:List<Comment> = emptyList()
}

class Comment (val note_id:Int,val message:String,val reply_to:Int){
    var id:Int = 0
}
class CommentService: CrudService<Comment>{
    override fun add(element: Comment) {
        for ((index, note) in notes.withIndex()){
            if (note.id == element.note_id) {
                element.id = notes.get(index).comments.size + 1
                notes.get(index).comments.plusElement(element)
            }
        }
    }

    override fun del(element: Comment) {
        for ((indexNt, note) in notes.withIndex()){ // проход по заметкам
            if (note.id == element.note_id) {
                val comments =notes.get(indexNt).comments
                comments.get(comments.indexOf(element)).remove
                for ((indexCm, comment) in comments.withIndex()){//проход по комментам
                    if (comment.id == element.id) {
                        comments.get(indexCm).remove
                    }
                }
            }
        }
    }

    override fun get(id: Int): Comment? {
       // TODO("Not yet implemented")
    }

    override fun edit(element: Comment) {
       // TODO("Not yet implemented")
    }

}