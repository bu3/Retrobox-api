package io.pivotal.retrobox

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import java.time.ZonedDateTime

import static io.pivotal.retrobox.ItemStatus.ACTIVE
import static io.pivotal.retrobox.ItemType.HAPPY
import static java.time.ZoneOffset.UTC

@Component
class ItemService {

    @Autowired
    ItemRepository itemRepository

    Item[] findItems(Long boardId) {
        itemRepository.findByBoardId(boardId)
    }

    Item addItem(Item item) {
        def now = ZonedDateTime.now(UTC)
        itemRepository.save(new Item(boardId: item.boardId, message: item.message, type: HAPPY, status: ACTIVE, creationDate: now, lastModifiedDate: now))
    }
}