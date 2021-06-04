#!/bin/sh

gcloud functions deploy dafte --entry-point dafte.Dafte --runtime java11 --trigger-http --memory 512MB --allow-unauthenticated
