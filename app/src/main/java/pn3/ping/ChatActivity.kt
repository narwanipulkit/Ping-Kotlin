package pn3.ping

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.BaseAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.*

class ChatActivity : AppCompatActivity() {

    var listMessage = ArrayList<ChatMessage>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        var count: Int = 0
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("messages")

        list.adapter = MessageListAdapter(this, R.layout.message_item, listMessage)

        val listener = object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot?) {
                listMessage.clear()
                p0?.children!!
                        .map { it?.getValue(ChatMessage::class.java) }
                        .filter { it?.message != null }
                        .forEach {
                            listMessage.add(it!!)
                            Log.e("Message", it?.message)
                        }

                (list.adapter as BaseAdapter).notifyDataSetChanged()
                list.setSelection(listMessage.size - 1)

            }

            override fun onCancelled(p0: DatabaseError?) {
                Log.e("Error", p0?.details)

            }

        }
        ref.addValueEventListener(listener)
        ref.addListenerForSingleValueEvent(listener)

        send.setOnClickListener {
            val refe = ref.child("message" + Date().toString())
            count++
            val cm = ChatMessage(message.text.toString(), FirebaseAuth.getInstance().currentUser?.email!!)
            refe.setValue(cm)
        }


    }
}
