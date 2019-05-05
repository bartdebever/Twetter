package server

import java.io.IOException

import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerResponseContext
import javax.ws.rs.container.ContainerResponseFilter
import javax.ws.rs.ext.Provider

@Provider
open class CORSFilter : ContainerResponseFilter {

    @Throws(IOException::class)
    override fun filter(requestContext: ContainerRequestContext,
                        cres: ContainerResponseContext) {
        cres.headers.add("Access-Control-Allow-Origin", "*")
        cres.headers.add("Access-Control-Allow-Headers", "*")
        cres.headers.add("Access-Control-Allow-Credentials", "true")
        cres.headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
        cres.headers.add("Access-Control-Max-Age", "1209600")
    }

}
