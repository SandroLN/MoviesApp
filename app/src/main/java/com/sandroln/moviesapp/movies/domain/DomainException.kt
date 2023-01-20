package com.sandroln.moviesapp.movies.domain

abstract class DomainException : IllegalStateException()

class NoConnectionException : DomainException()

class ServiceUnavailable : DomainException()