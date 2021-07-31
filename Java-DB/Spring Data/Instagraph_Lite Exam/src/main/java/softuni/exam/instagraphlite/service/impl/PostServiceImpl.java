package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import softuni.exam.instagraphlite.models.models.entity.Posts;
import softuni.exam.instagraphlite.models.models.xmldto.PostsSeedRootDto;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class PostServiceImpl implements PostService {
    public static final String POST_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PictureService pictureService;
    private final UserService userService;
    private final PostRepository postRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PostServiceImpl(PictureService pictureService, UserService userService, PostRepository postRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.pictureService = pictureService;
        this.userService = userService;
        this.postRepository = postRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(POST_FILE_PATH, PostsSeedRootDto.class)
                .getPosts()
                .stream()
                .filter(postsSeedDto -> {
                    boolean isValid = validationUtil.isValid(postsSeedDto)
                            && userService.isEntityExists(postsSeedDto.getUser().getUsername())
                            && pictureService.isEntityExists(postsSeedDto.getPicture().getPath());

                    sb.append(isValid ? String.format("Successfully imported Post, made by %s",
                            postsSeedDto.getUser().getUsername()) : String.format("Invalid Post"));
                    sb.append(System.lineSeparator());

                    return isValid;
                })
                .map(postsSeedDto -> {
                    Posts posts = modelMapper.map(postsSeedDto, Posts.class);

                    posts.setUser(userService.findByUsername(postsSeedDto.getUser().getUsername()));
                    posts.setPicture(pictureService.findByPath(postsSeedDto.getPicture().getPath()));

                    return posts;
                })
                .forEach(postRepository::save);
        return sb.toString();
    }
}
