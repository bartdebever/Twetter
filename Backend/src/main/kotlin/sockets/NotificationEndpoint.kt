//package sockets
//
//import java.io.IOException
//import javax.websocket.server.ServerEndpoint
//import java.util.HashMap
//import java.util.concurrent.CopyOnWriteArraySet
//import javax.websocket.*
//import javax.websocket.server.PathParam
//
//
//@ServerEndpoint(value = "notifications/{userId}")
//public class NotificationEndpoint {
//
//    private var session: Session? = null
//    private val chatEndpoints = CopyOnWriteArraySet<NotificationEndpoint>()
//    private val users = HashMap<String, String>()
//
//    @OnOpen
//    fun onOpen(
//            session: Session,
//            @PathParam("username") username: String) {
//
//        this.session = session
//        chatEndpoints.add(this)
//        users[session.id] = username
//
//        broadcast("test")
//    }
//
//    @OnMessage
//    fun onMessage(session: Session, message: Any?) {
//        broadcast(message)
//    }
//
//    @OnClose
//    fun onClose(session: Session) {
//
//        chatEndpoints.remove(this)
//        broadcast("Test")
//    }
//
//    @OnError
//    fun onError(session: Session, throwable: Throwable) {
//        // Do error handling here
//    }
//
//    private fun broadcast(message: Any?) {
//        chatEndpoints.forEach { endpoint ->
//            synchronized(endpoint) {
//                try {
//                    endpoint.session!!.basicRemote.sendObject(message)
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                } catch (e: EncodeException) {
//                    e.printStackTrace()
//                }
//
//            }
//        }
//    }
//}