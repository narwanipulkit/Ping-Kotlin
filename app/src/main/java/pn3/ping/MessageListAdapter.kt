package pn3.ping

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by pulkitnarwani on 21/06/17.
 */
class MessageListAdapter (var ctx: Context,var resourceId: Int,var listMessage: ArrayList<ChatMessage>): BaseAdapter() {


    override fun getItem(p0: Int): Any {
        return listMessage[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listMessage.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v=LayoutInflater.from(ctx).inflate(resourceId,null)
        var mail=v.findViewById(R.id.email) as TextView
        var message=v.findViewById(R.id.mess) as TextView
        var layout=v.findViewById(R.id.item) as LinearLayout
        mail.text= listMessage[position].mail
        message.text= listMessage[position].message


        //layout.setHorizontalGravity(Gravity.RIGHT)
        if(listMessage[position].mail.equals(FirebaseAuth.getInstance().currentUser?.email!!))
            layout.gravity= Gravity.END

        return v

    }
}