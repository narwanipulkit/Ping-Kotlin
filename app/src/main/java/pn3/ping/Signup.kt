package pn3.ping

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() {

    var n : String? = null
    var mail : String? =null
    var password:String?=null
    var mAuth : FirebaseAuth= FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        signup.setOnClickListener{
            n=name.text.toString()
            mail=email.text.toString()
            password=pass.text.toString()

            if(mail !=null && password!=null)
                mAuth.createUserWithEmailAndPassword(mail!!, password!!).addOnCompleteListener(this, {
                    task -> Unit
                    if(task.isSuccessful) {
                        Log.e("Sign Up ", "Successful");
                    }
        })
    }
}
}
