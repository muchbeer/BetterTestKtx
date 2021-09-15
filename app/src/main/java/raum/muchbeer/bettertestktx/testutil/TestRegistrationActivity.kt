package raum.muchbeer.bettertestktx.testutil

object TestRegistrationActivity {
    private val existingUsers = listOf("Gianna", "Giovanna", "Gadiel")

    /**
     * the input is not valid if...
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the password contains less than 2 digits
     */
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        if(username.isEmpty() || password.isEmpty()) {
            return false
        }
        if(username in existingUsers) {
            return false
        }
        if(password != confirmedPassword) {
            return false
        }
        if(password.count {
                it.isDigit() } < 2) {
            return false
        }
        return true
    }

//**************************FIBONACCH******************************
  /*  Return the n-th fibonacci number
    they are defined like this
    fib(0) = 0
    fib(1) = 1
    fib(n) = fib(n-2) + fib(n-1)*/

    fun fib(n: Int) : Long {
        if(n==0 || n==1) {
            return n.toLong()
        }

    var a=0L
    var b=1L
    var c= 1L
    (1..n-1).forEach {
        c=a+b
        a=b
        b=c
    }
    return c
}
}