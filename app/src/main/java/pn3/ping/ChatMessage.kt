package pn3.ping

/**
 * Created by pulkitnarwani on 21/06/17.
 */
class ChatMessage constructor(){

    var mail: String=""
    var message : String=""


    constructor(mess: String, email : String) : this(){
        mail=email
        message=mess
    }
}