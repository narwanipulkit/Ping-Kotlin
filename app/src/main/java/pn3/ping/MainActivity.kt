package pn3.ping

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {


    private var password: String? = null
    private var mail: String? =null
    private var mAuth: FirebaseAuth?= FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signin.setOnClickListener{
                password=pass.text.toString()
                mail=email.text.toString()
                if(password !=null && mail!=null)
                    mAuth?.signInWithEmailAndPassword(mail!!,password!!)?.addOnCompleteListener(this, {
                        task ->
                        if(task.isSuccessful){
                            startActivity(intentFor<ChatActivity>())
                        } else{
                            Toast.makeText(this,"Authentication Error",Toast.LENGTH_LONG).show()
                        }
                    })

            }
        signup.setOnClickListener{
            startActivity(intentFor<Signup>())
        }


    }
}
