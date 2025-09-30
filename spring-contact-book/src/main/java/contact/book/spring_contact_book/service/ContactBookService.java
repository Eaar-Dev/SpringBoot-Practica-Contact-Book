package contact.book.spring_contact_book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import contact.book.spring_contact_book.model.ContactBookModel;
import contact.book.spring_contact_book.repository.ContactBookRepository;

@Service
public class ContactBookService {

    private final ContactBookRepository contactBookRepository;

    public ContactBookService(ContactBookRepository contactBookRepository) {
        this.contactBookRepository = contactBookRepository;
    }

    public List<ContactBookModel> getAll() {
        return contactBookRepository.findAll();
    }

    public Optional<ContactBookModel> getById(Long id) {
        return contactBookRepository.findById(id);
    }

    public List<ContactBookModel> searchByName(String name) {
        return contactBookRepository.findByName(name);
    }

    public List<ContactBookModel> searchByEmail(String email) {
        return contactBookRepository.findByEmail(email);
    }

    public ContactBookModel save(ContactBookModel contactBook) {
        return contactBookRepository.save(contactBook);
    }

    public void delete(Long id) {
        contactBookRepository.deleteById(id);
    }

}
