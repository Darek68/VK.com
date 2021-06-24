object WallService {
    private var nextId : Int = 0
    private var posts = emptyArray<Post>()

    fun  add(post : Post): Post {
        post.id = nextId
        nextId += 1
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val vId = post.id
        for ((index, vpost) in posts.withIndex()){
            if (vpost.id == vId) {
                posts[index] = post
                return true
            }
        }
        return false
    }

}