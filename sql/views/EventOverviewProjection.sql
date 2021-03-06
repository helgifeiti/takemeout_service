create view EventOverviewProjection
( id
, name
, time
-- joined columns
, typeId
, typeDescriptionEng
, typeDescriptionIce
, locationName
, address
, access )

as select
  e.id
, e.name
, e.time

, t.id
, t.descriptionEng
, t.descriptionIce
, l.name
, l.address
, l.access
from Event e

join TypeItem t on
  t.id = e.typeId

join Location l on
  l.id = e.locationId;
