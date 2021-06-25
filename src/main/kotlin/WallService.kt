

class WallService {

    private var posts = emptyArray<Post>()

    fun  add(post : Post): Post {
        posts += post.copy(id = if(posts.isEmpty()) 0 else posts.last().id + 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val vId = post.id
        for ((index, vpost) in posts.withIndex()){
            if (vpost.id == vId) {
                posts[index] = post.copy(owner_id = posts[index].owner_id,date = posts[index].date)
                return true
            }
        }
        return false
    }
}