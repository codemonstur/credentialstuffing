package stuffing.services;

public class Apple {

    // Page actually looks half decent. Once on the login page you don't get a bunch of unnecessary
    // junk code or HTTP calls. What you do get is some obfuscation drivel. A call to:
    // https://idmsa.apple.com/appleauth/auth/signin/init
    // Which retuns some form of challenge stuff:
    // {
    //  "iteration" : 2010,
    //  "salt" : "PbXUUdIkbilMmI2jiFmzbA==",
    //  "protocol" : "s2k_fo",
    //  "b" : "Dv8YZQRspMz+tfggBnkJoCCyMGr6jL1/3h1f2rSyNyT5PutbMVZzm0tbhuDTILO1YXButks3VgqQ4bnVEOKPKbba/s6iyZI1kgfphJDNbp9zh1pSbHEjwfppTr1SGvIjfDMG3Wtl8NlvYSdhx7UvWce+FnoMpc3/UYX9C6M/dosZdpJ+gJak1Q7fvuL1tpO0ZrSHZSt9jQf9u67KN1+IQh6RcEqThPps5qrBKODojcGoHIAq5gf9YiznFpqCthXyx4AAMrerFc16A+80yD1DKsNAK/vLlE4nx5u1TtPgpVDyP1jt/MDWk8rW1f+C9vk40wrwFKxvsFi5WSd38V9ioQ==",
    //  "c" : "d-628-232ae982-78f5-11ef-bd79-a5b2e353efe6:PRN"
    //}
    // The call to the login page then contains some additional stuff:
    // {"accountName":"test@test.com","rememberMe":false,"m1":"r0Ur9IWybTgBqIwaCt/V2he2+WDm+1B31kB3UPSDI2Q=","c":"d-628-232ae982-78f5-11ef-bd79-a5b2e353efe6:PRN","m2":"ABogvVDs5S/gkJxWIVy1AwSGLxZoQJ8LnBWSmQG/6yo="}
    // So 'c' is sent back as is but m1 and m2 are generated somehow. The salt and iteration suggests that this
    // is a proof-of-work designed to prevent brute-forcing.

}
