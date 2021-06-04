# Daily Advice For The Engineer (DAFTE)

DAFTE (or Dafte) is a learning project by Ben to explore building a Google Cloud Function. Or at least that's how it
started out.

After building out the basic use case as a GC Function, it seemed worthwhile to consider that a single use approach such
as a GC Function might not be the most efficient way to handle requests at various scales/capacities. To be fair to both
approach, the project was adapted to either run as a deployed GC Function, or as a Standalone Spark microservice.
