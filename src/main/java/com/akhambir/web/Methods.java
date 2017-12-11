package com.akhambir.web;

public enum Methods {

    GET {
        @Override
        public String toString() {
            return "GET";
        }
    },
    POST {
        @Override
        public String toString() {
            return "POST";
        }
    }
}
